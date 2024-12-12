# Load necessary library
library(ggplot2)

# Define file paths
args <- commandArgs(trailingOnly = TRUE)
input_folder <- ifelse(length(args) > 0, args[1], "../labels/")
output_pdf <- "plots/summary.pdf"

# List the CSV files in the input folder
csv_files <- list.files(path = input_folder, pattern = "*.csv", full.names = TRUE)

# Define a vector of files to exclude
files_to_exclude <- c("label-XXX.csv")

# Exclude the specific files from the list
csv_files <- csv_files[!basename(csv_files) %in% files_to_exclude]

# Initialize an empty data frame to store the results
results <- data.frame(File = character(), Sum = numeric(), stringsAsFactors = FALSE)

# Loop over each CSV file
for (file in csv_files) {
  # Extract the 'XXX' part of the filename (remove 'label-' and '.csv')
  file_name <- sub("^label-(.*)\\.csv$", "\\1", basename(file))
  
  # Read the CSV file
  data <- read.csv(file)

  # Filter the data to exclude rows where "Transformation Aspect" is "EMPTY"
  data_filtered <- data[data$Transformation.Aspect != "EMPTY", ]
  
  # Sum the specific column (replace 'column_name' with the actual column name)
  column_sum <- sum(data_filtered$Value, na.rm = TRUE)  # Replace 'column_name' with your actual column name
  
  # Store the result in the results data frame
  results <- rbind(results, data.frame(File = file_name, Sum = column_sum))
}

# Create the output directory if it doesn't exist
if (!dir.exists("plots")) {
  dir.create("plots")
}

# Save the plot to a PDF
pdf(output_pdf)

# Plot the results
ggplot(results, aes(x = File, y = Sum, fill = File)) +
  geom_bar(stat = "identity") +
  labs(title = "Total word count per solution", x = "Solution", y = "Word count") +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))  # Rotate x-axis labels for better readability

# Close the PDF device
dev.off()

cat("Plot has been saved to", output_pdf, "\n")
