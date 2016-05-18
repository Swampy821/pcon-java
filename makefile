

all: stop build-js build-java build-docker run-docker location

build-js:
	@cd frontend && \
		webpack && \
		cd ../

build-java:
	@./gradlew build

build-docker:
	@docker build -t rest-service .

run-docker:
	@docker run -d --name rest-service -p 8080:8080 rest-service

stop-docker:
	@docker kill rest-service && \
		docker rm rest-service

status:
	@docker ps
start: run-docker
stop: stop-docker
build: build-java build-docker

location:
	@docker-machine ip default