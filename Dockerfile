FROM mysql:8

ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_DATABASE=restaurant
ENV MYSQL_USER=restaurant_user
ENV MYSQL_PASSWORD=1234

COPY ./sql/restaurant-schema.sql /docker-entrypoint-initdb.d/
RUN chmod 644 /docker-entrypoint-initdb.d/restaurant-schema.sql