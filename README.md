
https://github.com/user-attachments/assets/2b0cd3e0-5fd3-4c7c-b4c3-28d0f2d156cf

### Étape 1 : Création de l’interface graphique

Dans le fichier `activity_main.xml`, nous avons créé l’interface utilisateur de l’application.  
Cette interface contient plusieurs champs de saisie permettant d’entrer le nom, l’adresse, la surface de la maison et le nombre de pièces.

<img width="1353" height="1346" alt="image" src="https://github.com/user-attachments/assets/660f51ea-e6cf-4cbb-a5fc-5d5233447a75" />


Nous avons aussi ajouté une case à cocher `CheckBox` pour indiquer la présence ou non d’une piscine, ainsi qu’un bouton `Calculer` pour lancer le calcul.

### Étape 2 : Liaison entre XML et Java

Dans le fichier `MainActivity.java`, nous avons relié les éléments de l’interface avec le code Java grâce à la méthode `findViewById()`.
<img width="1533" height="1411" alt="image" src="https://github.com/user-attachments/assets/f8c0ad2b-1b4e-4057-9229-9b2de572a49b" />


Cette étape permet de récupérer les valeurs saisies par l’utilisateur dans les champs de texte.

### Étape3 : Traitement des données

Après le clic sur le bouton `Calculer`, l’application lit la surface, le nombre de pièces et l’état de la case piscine.

Ensuite, elle applique les règles suivantes :

- Impôt de base = surface × 2
- Supplément = nombre de pièces × 50
- Si la maison possède une piscine, on ajoute 100 DH


