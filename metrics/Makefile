FOLDERS := $(wildcard ../solutions/*/)
FIGURES := $(addprefix plots/, $(addsuffix .pdf,$(notdir $(FOLDERS:/=))))
LABELS := $(addprefix ../labels/label-, $(addsuffix .csv,$(notdir $(FOLDERS:/=))))

.PHONY: all clean 

all: docker ../utils/LabelCounting/build/libs/LabelCounting-all.jar $(FIGURES) $(LABELS) ## uncomment so that make keeps CSV files with labels

plots/%.pdf: ../labels/label-%.csv
	@echo "Generating figure for $*.."
	touch plots/$*.pdf
	docker run --rm \
			-v $(shell pwd)/../labels/label-$*.csv:/$*.csv \
			-v $(shell pwd)/plots/$*.pdf:/$*.pdf \
			incr-c2r-plot:latest /usr/bin/Rscript generate-plots.r $*

../labels/label-%.csv: ../utils/LabelCounting/build/libs/LabelCounting-all.jar FORCE
	@echo "Generating labels for $*.."
	cd ../utils/LabelCounting && java -jar build/libs/LabelCounting-all.jar $*

docker: Dockerfile generate-plots.r
	@echo "Building docker image..."
	docker build -t incr-c2r-plot .

../utils/LabelCounting/build/libs/LabelCounting-all.jar:
	cd ../utils/LabelCounting && ./gradlew build

clean:
	@echo "Cleaning up..."
	rm -f plots/*
	rm -f ../labels/*
	find . -name '*.csv' -delete

docker-clean:
	@echo "Removing docker image..."
	docker rmi incr-c2r-plot
	
FORCE:
