library(ggplot2)
library(dplyr)

savePlot <- function(plot, name) {
        pdf(name)
        print(plot)
        dev.off()
}

createPlot <- function(data, title) {

	# Define the order of types for stacking
	type_order <- c("SETUP", "MODEL_TRAVERSAL", "CHANGE_PROPAGATION", "HELPER", "TRACING", "CHANGE_IDENTIFICATION", "TRANSFORMATION", "EMPTY", "WRAPPER")

	# Fill missing types with 0 values
	missing_types <- setdiff(type_order, unique(data$Transformation.Aspect))
	missing_data <- data.frame(File.name=0,Transformation.Aspect = missing_types, Value = 0, Lines=0)
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
  	  scale_fill_manual(values = c("#F8766D", "#C49A00", "#53B400", "#00C094", "#00B5EB", "#619CFF", "#ABABAB", "#FF00FF", "#EFEFEF")) +
	  xlab("Transformation Aspect") +
	  ylab("Word Count") +
	  ggtitle(title) +
	  theme_bw() +
	  theme(plot.title = element_text(hjust = 0.5)) +
	  guides(fill = guide_legend(reverse = TRUE, override.aes = list(order = type_order))) +
	  geom_text(aes(label = paste0(Value, " (", round(Percentage, 1), "%)")), 
            position = position_stack(vjust = 0.5), size = 3)
}

options(echo=TRUE)
args <- commandArgs(trailingOnly = TRUE)
print(args)

solution <- args[1]

values <- read.csv(paste0("../labels/", solution, ".csv"), header = TRUE, , sep = ",", stringsAsFactors = FALSE)
values$Transformation.Aspect <- trimws(values$Transformation.Aspect)
valuesPlot <- createPlot(values, solution)
savePlot(valuesPlot, paste0("plots/", solution, ".pdf"))

