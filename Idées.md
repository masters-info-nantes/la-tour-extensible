-- La Tour Extensible --

plate-forme :
	-> chargement/lecture des plugins
	-> doit rester générique
	-> hook?
	-> gestion d'évènements

Demo : 
	Un perso principal s'en va conquérir une tour remplie de monstres
	En gravissant cette tour, votre personnage gagnera de l'expérience et aura accès à de nouvelles armes.

plugins :
	* -> un par salle / niveau
	* -> interface menu / combat
	* -> personnages (style de perso / monstres) + états
	* -> producteurs de monstres/personnages
	* -> actions 
	* -> core
	  -> création perso
	  -> générateur plugin minimum
	  -> sauvegarde
	  -> "boutique"
	  -> armes
	
Une salle correspond à un bonus ou malus pour le personnage.

"Personnage"
 int force
 int defense
 int vie
 State etat
	| 		  \
"Héro"			"Monstre"
 Job job		 Attribut
 Race race

Actions
 domaine
 valeur




idée sadique: une salle vide, le héros meurt sur le coup
