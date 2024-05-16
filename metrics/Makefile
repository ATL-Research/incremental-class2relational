FOLDERS := $(wildcard ../solutions/*/)
FIGURES := $(addprefix plots/, $(addsuffix .pdf,$(notdir $(FOLDERS:/=))))

.PHONY: all

all: $(FIGURES)

plots/%.pdf: ../labels/%.csv
	@echo "Generating figure for $(subst plots/,,$*).."
	@Rscript generate-plots.r $(subst plots/,,$*)	

../labels/%.csv:
	@echo "Generating labels for $(subst ../labels/,,$*).."
	@cd ../utils/LabelCounting && ./gradlew -q run --args='$(subst ../labels/,,$*)'

clean:
	@echo "Cleaning up..."
	rm -f plots/*
	rm -f ../labels/*
	find . -name '*.csv' -delete
