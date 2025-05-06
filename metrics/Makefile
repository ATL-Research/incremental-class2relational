FOLDERS := $(wildcard ../solutions/*/)
LABELS := $(addprefix ../labels/label-, $(addsuffix .csv,$(notdir $(FOLDERS:/=))))
TAR_DIR := ./plots
FIGURES := $(addprefix $(TAR_DIR)/, $(addsuffix .pdf,$(notdir $(FOLDERS:/=)))) $(TAR_DIR)/javaEMF-batch.pdf $(TAR_DIR)/summary.pdf
UID := $(shell id -u)
GID := $(shell id -g)

.PHONY: all clean docker counter

all: docker counter $(FIGURES) $(LABELS) ## uncomment so that make keeps CSV files with labels

counter:
	cd ../utils/LabelCounting && ./gradlew build

$(TAR_DIR)/summary.pdf: $(LABELS)
	@echo "Generating the summary plot"
	touch $(TAR_DIR)/summary.pdf
	docker run --rm \
			--user $(UID):$(GID) \
			-v $(shell pwd)/labels/:/labels \
			-v $(shell pwd)/$(TAR_DIR)/summary.pdf:/$(TAR_DIR)/summary.pdf \
			incr-c2r-plot:latest /usr/bin/Rscript generate-summary.r /labels
	@echo "Generating the summary plot per aspects"
	docker run --rm \
			--user $(UID):$(GID) \
			-v $(shell pwd)/labels/:/labels \
			-v $(shell pwd)/$(TAR_DIR)/:/$(TAR_DIR)/ \
			incr-c2r-plot:latest /usr/bin/Rscript generate-summary-per-aspect.r /labels
	@echo "Generating the a merged summary"
	touch $(TAR_DIR)/merge-summary.pdf
	docker run --rm \
			--user $(UID):$(GID) \
			-v $(shell pwd)/labels/:/labels \
			-v $(shell pwd)/$(TAR_DIR)/merge-summary.pdf:/$(TAR_DIR)/merge-summary.pdf \
			incr-c2r-plot:latest /usr/bin/Rscript generate-merge-summary.r /labels

$(TAR_DIR)/%.pdf: ../labels/label-%.csv | $(TAR_DIR) 
	@echo "Generating figure for $*.."
	touch $(TAR_DIR)/$*.pdf
	docker run --rm \
			--user $(UID):$(GID) \
			-v $(shell pwd)/labels/label-$*.csv:/$*.csv \
			-v $(shell pwd)/$(TAR_DIR)/$*.pdf:/$*.pdf \
			incr-c2r-plot:latest /usr/bin/Rscript generate-plots.r $*

$(TAR_DIR):
	mkdir -p $@ 

../labels/label-%.csv: counter FORCE
	@echo "Generating labels for $*.."
	cd ../utils/LabelCounting && java -jar build/libs/LabelCounting-all.jar $*

docker: Dockerfile generate-plots.r
	@echo "Building docker image..."
	docker build -t incr-c2r-plot .

clean:
	@echo "Cleaning up..."
	rm -f $(TAR_DIR)/*
	rm -f ../labels/*
	find . -name '*.csv' -delete

docker-clean:
	@echo "Removing docker image..."
	docker rmi incr-c2r-plot
	
FORCE:
