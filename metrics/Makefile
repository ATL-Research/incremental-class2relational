FOLDERS := $(wildcard */)
SCRIPTS := $(addsuffix -extract-metric-data.sh,$(notdir $(FOLDERS:/=)))

.PHONY: all

all: $(SCRIPTS)
	@echo "Executing R script"
	R -f generate-plots.r BATCH

%-extract-metric-data.sh:
	@if [ -f $(subst -extract-metric-data.sh,,$@)/$@ ]; then \
		echo "Executing script in $(subst -extract-metric-data.sh,,$@)/$@"; \
		cd $(subst -extract-metric-data.sh,,$@) && sh $@; \
	else \
		echo "Script $(subst -extract-metric-data.sh,,$@)/$@ not found. Skipping."; \
	fi

clean:
	@echo "Cleaning up..."
	rm -f plots/*
	find . -name '*.csv' -delete
