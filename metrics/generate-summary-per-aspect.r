# Load necessary library
library(ggplot2)

# Define file paths
args <- commandArgs(trailingOnly = TRUE)
input_folder <- ifelse(length(args) > 0, args[1], "../labels/")
output_folder <- "plots/"

# List the CSV files in the input folder
csv_files <- list.files(path = input_folder, pattern = "*.csv", full.names = TRUE)

# Define a vector of files to exclude
files_to_exclude <- c("label-XXX.csv")

# Exclude the specific files from the list
csv_files <- csv_files[!basename(csv_files) %in% files_to_exclude]

# Create the output directory if it doesn't exist
if (!dir.exists(output_folder)) {
  dir.create(output_folder)
}

# Initialize a data frame to store aggregated results
results <- data.frame(File = character(), Transformation.Aspect = character(), Sum = numeric(), stringsAsFactors = FALSE)

# Loop over each CSV file
for (file in csv_files) {
  # Extract the 'XXX' part of the filename (remove 'label-' and '.csv')
  file_name <- sub("^label-(.*)\\.csv$", "\\1", basename(file))
  
  # Read the CSV file
  data <- read.csv(file)
  
  # Debug: Print column names
  cat("Columns in file", file_name, ":", colnames(data), "\n")
  
  # Filter the data to exclude rows where "Transformation Aspect" is "EMPTY"
  if (!("Transformation.Aspect" %in% colnames(data)) || !("Value" %in% colnames(data))) {
    cat("Missing required columns in file:", file_name, "\n")
    next
  }
  
  data_filtered <- data[data$Transformation.Aspect != "EMPTY", ]
  
  # Group data by "Transformation Aspect" and calculate the sum of "Value"
  grouped_data <- aggregate(Value ~ Transformation.Aspect, data = data_filtered, sum)
  grouped_data$File <- file_name
  
  # Append grouped data to the results data frame
  results <- rbind(results, grouped_data)
}

# Generate a separate plot for each "Transformation Aspect"
unique_aspects <- unique(results$Transformation.Aspect)
for (aspect in unique_aspects) {
  # Filter results for the current "Transformation Aspect"
  aspect_data <- results[results$Transformation.Aspect == aspect, ]
  
  # Debug: Print aspect data
  print(paste("Data for Transformation Aspect:", aspect))
  print(aspect_data)
  
  # Skip if no data
  if (nrow(aspect_data) == 0) {
    cat("No data for Transformation Aspect:", aspect, "\n")
    next
  }
  
  # Define output PDF file name
  output_pdf <- file.path(output_folder, paste0("summary_", aspect, ".pdf"))
  
  # Save the plot to a PDF
  pdf(output_pdf)
  
  # Generate the plot
  p <- ggplot(aspect_data, aes(x = File, y = Value, fill = File)) +
    geom_bar(stat = "identity") +
    labs(
      title = paste("Total Word Count for Transformation Aspect:", aspect),
      x = "File",
      y = "Sum of Values"
    ) +
    theme(axis.text.x = element_text(angle = 45, hjust = 1), legend.position = "none")
  
  print(p)  # Ensure the plot is printed to the device
  
  # Close the PDF device
  dev.off()
  
  cat("Plot for", aspect, "has been saved to", output_pdf, "\n")
}
