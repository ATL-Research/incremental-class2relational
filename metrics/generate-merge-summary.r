# Load necessary library
library(ggplot2)
library(dplyr)

# Define file paths
args <- commandArgs(trailingOnly = TRUE)
input_folder <- ifelse(length(args) > 0, args[1], "labels/")
output_pdf <- "plots/merge-summary.pdf"

# List the CSV files in the input folder
csv_files <- list.files(path = input_folder, pattern = "*.csv", full.names = TRUE)

# Define a vector of files to exclude
files_to_exclude <- c()#"label-cheptre.csv", "label-refinery")

# Exclude the specific files from the list
csv_files <- csv_files[!basename(csv_files) %in% files_to_exclude]

# Initialize an empty data frame to store the results
results <- vector("list", length(csv_files))

# type_order <- c("SETUP", "MODEL_TRAVERSAL", "CHANGE_PROPAGATION", "HELPER", "TRACING", "CHANGE_IDENTIFICATION", "TRANSFORMATION", "EMPTY")
type_order <- c("SETUP", "HELPER", "MODEL_TRAVERSAL", "TRACING", "TRANSFORMATION", "CHANGE_IDENTIFICATION", "CHANGE_PROPAGATION", "EMPTY")
color_values = c("#F8766D", "#C49A00", "#53B400", "#00C094", "#00B5EB", "#619CFF", "#ABABAB", "#FF00FF", "#EFEFEF")
names(color_values) <- type_order

i <- 0
# Loop over each CSV file
for (file in csv_files) {
  i <- i + 1
  # Extract the 'XXX' part of the filename (remove 'label-' and '.csv')
  file_name <- sub("^label-(.*)\\.csv$", "\\1", basename(file))
  
  # Read the CSV file
  data <- read.csv(file)

  # Filter the data to exclude rows where "Transformation Aspect" is "EMPTY"
  data_filtered <- data[data$Transformation_Aspect != "EMPTY", ]
	
  data_filtered <- data_filtered %>% mutate(Transformation_Aspect = factor(Transformation_Aspect, levels = type_order))

	# Calculate the total value for each typetype_ord
	data_summary <- data %>%
	  mutate(Total = sum(Value, na.rm = TRUE)) %>%
	  group_by(Transformation_Aspect, Total) %>%
	  reframe(Value = sum(Value, na.rm = TRUE), Percentage = Value / Total * 100, File = file_name) %>% 
    ungroup() %>%
    unique()


  # Sum the specific column (replace 'column_name' with the actual column name)
  #column_sum <- sum(data_filtered$Value, na.rm = TRUE)  # Replace 'column_name' with your actual column name
  
  # Store the result in the results data frame
  results[[i]] <- data_summary
}

results <- dplyr::bind_rows(results, .id = "id")

# Create the output directory if it doesn't exist
if (!dir.exists("plots")) {
  dir.create("plots")
}

# Save the plot to a PDF
pdf(output_pdf)

# Plot the results
ggplot(results, aes(x = File, y = Value, fill = Transformation_Aspect)) +
  geom_bar(stat = "identity") +
  geom_text(data = results %>% select(File, Total) %>% unique(), mapping = aes(x = File, label = Total, y = Total), inherit.aes = FALSE, size = 3, position = position_stack(), vjust = 0) +
  geom_text(aes(label = paste0(signif(Percentage, 2), "%"), alpha = Percentage > 3), show.legend = FALSE, size = 2, position = position_stack(vjust = 0.5)) +
  scale_fill_manual(values = color_values) +
  scale_alpha_manual(values = c(0, 1)) +
  labs(title = "Total word count per solution", x = "Solution", y = "Word count") +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))  # Rotate x-axis labels for better readability and get rid of the legend on the right

# Close the PDF device
dev.off()

cat("Plot has been saved to", output_pdf, "\n")
