## Coses realitzades
- Agency:
	- Afegit l'atribut estátic lastID.
	- Afegits métodes per afegir 'Bookables'

- Acommodation:
	- implementat BookableHousing
	- Creats els atributs
		- id
		- cleaningCosts
		- maxAllowedPeople
		- petsAllowed
	- Creat un constructor per als atributs
	- Implementats els métodes necesaris que manen les interficies
- Appartment:
	- Afegit l'atribut MIN_COST_DAY, que despres sobreescriurem a cada un dels apartaments.
	- Constructor que crida a Acommodation amb la mateixa firma
	- Sobreescrit el métode per afegir periódes de reserva. En aquest, si el preu no arriba al mínim, s'actualitza i mostra un error.
- BeachAppartment i MountainAppartment:
	- Constructor que crida al constructor d'Appartment, estableix el preu mínim (NO a través de l'usuari) i crida al métode d'afegir periodes de Appartment.
- SkiResportAppartment:
	- El mateix que a Beach i Mountain, peró al preu li suma el preu del seu 'super', es a dir, MountainAppartment.
- Car:
	- Implementat Bookable
	- Afegits els atributs i métodes que mana l'interficie
	- Imitat el comportament de Appartment.
- Villa 
	- Constructor que crida al constructor de Acommodation i afegeix els periodes de reserva.

####Extra
- Al fer una reserva (métode Book d'Acommodation i de Car):
	- Es crea un periode del temps disponible que hi ha entre l'inici del periode original i la data d'inici de la reserva, amb les característiques originals.
	- El periode seleccionat es transforma en el periode de la reserva, i es queda en un estat no disponible.
	- Es crea un periode del temps disponible que hi ha entre el final de la reserva i el final del periode original, amb les caracteristiques originals.
- Totes les dates es poden passar en format String (dd/mm/yyyy)
- Afegits toString() per tot arreu.