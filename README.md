# **`Technical test`**

Salut et bienvenue ici. Auchan te propose de consacrer un peu de temps pour nous exposer tes talents.

Tu trouveras ici le squelette d'un projet **Sprint Boot 2.3 (JAVA)** / **MongoDB** et **VUE 3 (TypeScript)**.

Passe ici 2-3 heures avec pour objectif de **créer un endpoint permettant de créer un objet qui va s'inscrire dans une collection MongoDB** de ton choix. 

Un autre endpoint permettra d'**enrichir cette collection avec de nouveaux objets** (maximum 2-3 attributs, on ne demande pas la lune !) et enfin un front avec une **single page qui expose la liste des objets** contenus dans ta collection.

Pas de fioritures, pas de piège, pas de bonne ou mauvaise façon de faire, ce sera juste l'occasion pour toi de créer un support sur lequel baser notre prochaine rencontre.
Have fun !

**Si tu rencontres un problème n'hésite pas à créer une issue sur le repo que tu as fork et on répondra aussi vite que possible !**

## Solution:   Backend
First step setup Docker environment
```shell
docker build -t person-managment  .
```
then
```shell
docker run -d --name person-managment -p 27017:27017   person-managment 
```
Once you've MongoDB up, you can run the application.

For test you can run the following curls: 
```shell
curl --location 'localhost:8080/persons/list-upsert' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "id": "64d63a602f51bc2abf5bc08f",
        "name": " tata 20 ",
        "email": "toto.titi20@gmail.com",
        "courseList": null,
        "gpa": 0.0
    },
    {
        "id": "64d63ae22f51bc2b28c11a3e",
        "name": " tata 22",
        "email": "toto.titi 24 @gmail.com",
        "courseList": null,
        "gpa": 0.0
    }
]'
```
or 
```shell
curl --location 'localhost:8080/persons/'
```
