library(ggplot2)
library(dplyr)

savePlot <- function(plot, name) {
        pdf(name)
        print(plot)
        dev.off()
}

createPlot <- function(data, title) {

	# Define the order of types for stacking
	#type_order <- c("SETUP", "HELPER", "MODEL_TRAVERSAL", "TRACING", "TRANSFORMATION", "CHANGE_IDENTIFICATION", "CHANGE_PROPAGATION")
    #color_values = c("#F8766D", "#C49A00", "#53B400", "#00C094", "#00B5EB", "#619CFF", "#ABABAB", "#FF00FF", "#EFEFEF")
	type_order <- c("CHANGE_IDENTIFICATION", "CHANGE_PROPAGATION", "HELPER", "MODEL_TRAVERSAL", "SETUP", "TRACING", "TRANSFORMATION")
	color_values = c("#619CFF", "#ABABAB", "#C49A00", "#53B400", "#F8766D", "#00C094", "#00B5EB")#, "#FF00FF", "#EFEFEF")

	names(color_values) <- type_order
	# Fill missing types with 0 values
	#missing_types <- setdiff(type_order, unique(data$Transformation.Aspect))
	#missing_data <- if (!length(missing_types)) data.frame(File.name=0,Transformation.Aspect = missing_types, Value = 0, Lines=0) else NULL
	#data <- rbind(data, missing_data)
	
#	data_filtered <- data[data$Transformation_Aspect != "EMPTY",]
#  	data_filtered <- data_filtered[data_filtered$Transformation_Aspect != "GENERATED",]
  	data_filtered <- data[!data$Transformation_Aspect %in%  c("EMPTY","GENERATED"),]
    #data <- data %>% mutate(Transformation_Aspect = factor(Transformation_Aspect, levels = type_order))
    data_filtered <- data_filtered %>% mutate(Transformation_Aspect = factor(Transformation_Aspect, levels = type_order))

	# Calculate the total value for each typetype_ord
	data_summary <- data_filtered %>%
	  mutate(Total = sum(Value)) %>%
	  group_by(Transformation_Aspect) %>%
	  reframe(Value = sum(Value), Percentage = Value / Total * 100) %>% unique()

	# Create the stacked bar plot
	plot <- ggplot(data_summary, aes(x = "", y = Value, fill = Transformation_Aspect)) +
	  geom_bar(stat = "identity") +
  	  scale_fill_manual(values = color_values) +
	  xlab("Transformation Aspect") +
	  ylab("Word Count") +
	  ggtitle(title) +
	  theme_bw() +
	  theme(plot.title = element_text(hjust = 0.5)) +
	  #guides(fill = guide_legend(reverse = TRUE, override.aes = list(order = type_order))) #+
	  geom_text(aes(label = paste0(Value, " (", round(Percentage, 1), "%)")), 
            position = position_stack(vjust = 0.5), size = 3)
}

args <- commandArgs(trailingOnly = TRUE)
print(args)

solution <- args[1]

values <- read.csv(paste0(solution, ".csv"), header = TRUE, , sep = ",", stringsAsFactors = FALSE)
values$Transformation_Aspect <- trimws(values$Transformation_Aspect)
valuesPlot <- createPlot(values, solution)
savePlot(valuesPlot, paste0(solution, ".pdf"))

