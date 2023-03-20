1) Сбилдить образ 

> docker build -t hello_world_image .   


2) Запустить полученный из образа контейнер 

> docker run --name hello_world_container -p 8081:8081 hello_world_image 

