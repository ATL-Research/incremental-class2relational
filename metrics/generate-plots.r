library(ggplot2)
library(dplyr)

savePlot <- function(plot, name) {
        pdf(name)
        print(plot)
        dev.off()
}

createPlot <- function(data, title) {

	# Define the order of types for stacking
	type_order <- c("Setup", "Model Traversal", "Model Navigation", "Change Propagation", "Helper", "Tracing", "Incrementality", "Transformation")

	# Fill missing types with 0 values
	missing_types <- setdiff(type_order, unique(data$Transformation.Aspect))
	missing_data <- data.frame(Transformation.Aspect = missing_types, Value = 0)
	data <- rbind(data, missing_data)
	
	# Calculate the total value for each type
	data_summary <- data %>%
	  group_by(Transformation.Aspect) %>%
	  summarise(Value = sum(Value))

	# Calculate the total and percentage values
	data_summary <- data_summary %>%
		  mutate(Total = sum(Value),
	         Percentage = Value / Total * 100)

	# Create the stacked bar plot
	plot <- ggplot(data_summary, aes(x = "", y = Value, fill = Transformation.Aspect)) +
	  geom_bar(stat = "identity") +
  	  scale_fill_manual(values = c("#F8766D", "#C49A00", "#53B400", "#00C094", "#00B5EB", "#619CFF", "#ABABAB", "#FF00FF")) +
	  xlab("Transformation Aspect") +
	  ylab("Word Count") +
	  ggtitle(title) +
	  theme_bw() +
	  theme(plot.title = element_text(hjust = 0.5)) +
	  guides(fill = guide_legend(reverse = TRUE, override.aes = list(order = type_order))) +
	  geom_text(aes(label = paste0(Value, " (", round(Percentage, 1), "%)")), 
            position = position_stack(vjust = 0.5), size = 3)
}

# Read the CSV files
## atl
atl <- read.csv("atl/atl-metrics.csv", header = TRUE, , sep = ",", stringsAsFactors = FALSE)
atl$Transformation.Aspect <- trimws(atl$Transformation.Aspect)
atlPlot <- createPlot(atl, "atl")

## atol
atol <- read.csv("atol/atol-metrics.csv", header = TRUE, , sep = ",", stringsAsFactors = FALSE)
atol$Transformation.Aspect <- trimws(atol$Transformation.Aspect)
atolPlot <- createPlot(atol, "atol")

## cheptre
cheptre <- read.csv("cheptre/cheptre-metrics.csv", header = TRUE, , sep = ",", stringsAsFactors = FALSE)
cheptre$Transformation.Aspect <- trimws(cheptre$Transformation.Aspect)
cheptrePlot <- createPlot(cheptre, "Cheptre")

## csharp
csharp <- read.csv("csharp/csharp-metrics.csv", header = TRUE, , sep = ",", stringsAsFactors = FALSE)
csharp$Transformation.Aspect <- trimws(csharp$Transformation.Aspect)
csharpPlot <- createPlot(csharp, "csharp")

## nmf
nmf <- read.csv("nmf/nmf-metrics.csv", header = TRUE, , sep = ",", stringsAsFactors = FALSE)
nmf$Transformation.Aspect <- trimws(nmf$Transformation.Aspect)
nmfPlot <- createPlot(nmf, "nmf")

# Print the plots
savePlot(atlPlot, "plots/atl.pdf")
savePlot(atolPlot, "plots/atol.pdf")
savePlot(cheptrePlot, "plots/cheptre.pdf")
savePlot(csharpPlot, "plots/csharp.pdf")
savePlot(nmfPlot, "plots/nmf.pdf")


#savePlot(cheptrePlot, "plots/cheptre.pdf")
