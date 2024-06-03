FOLDERS := $(wildcard ../solutions/*/)
FIGURES := $(addprefix plots/, $(addsuffix .pdf,$(notdir $(FOLDERS:/=))))
LABELS := $(addprefix ../labels/label-, $(addsuffix .csv,$(notdir $(FOLDERS:/=))))


.PHONY: all clean 

all: docker $(FIGURES) $(LABELS) ## uncomment so that make keeps CSV files with labels

plots/%.pdf: ../labels/label-%.csv
	@echo "Generating figure for $*.."
	touch plots/$*.pdf
	docker run --rm -it \
			-v $(shell pwd)/../labels/label-$*.csv:/$*.csv \
			-v $(shell pwd)/plots/$*.pdf:/$*.pdf \
			incr-c2r-plot:latest /usr/bin/Rscript generate-plots.r $*

../labels/label-%.csv: FORCE
	@echo "Generating labels for $*.."
	cd ../utils/LabelCounting && ./gradlew -q run --args='$*'

docker: Dockerfile generate-plots.r
	@echo "Building docker image..."
	docker build -t incr-c2r-plot .

clean:
	@echo "Cleaning up..."
	rm -f plots/*
	rm -f ../labels/*
	find . -name '*.csv' -delete

docker-clean:
	@echo "Removing docker image..."
	docker rmi incr-c2r-plot
	
FORCE:
