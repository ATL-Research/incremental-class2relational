FROM r-base:4.4.0

RUN Rscript -e 'install.packages(c("ggplot2", "dplyr"))'

COPY *.r /

CMD ["/usr/bin/Rscript", "/generate-plots.r"]