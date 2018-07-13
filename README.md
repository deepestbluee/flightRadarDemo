# flightRadarDemo
Flight radar demo implemented for summer internship program at C-Tech .

THIS PROJECT IS NOT COMPLETELY DONE !
Things that are missing:
	1-) Database architecture is not correct. Needs to have route arrays for unique planes but in this version it has only coordinates for unique plane -This is done by purpose to test another aspect- .
	2-) Plane icons are just black points. They need to be airplane images.
	3-) Reload only the necessary part of the map(!) -not page- whenever the database is changed.
	4-) Coordinate Factory for database. Adding new coordinates is manual for this version .


Requirements:
	1-) Geoserver that runs at given ip in geoserver.html for getting wms and wfs layers.
	2-) MySQL server at port 3306 needs to initialized. XAMPP can be used.
	3-) Google Chrome needs "Allow-Control-Allow-Origin: *" application and Geoserver cors settings needs to be done.
	4-) For full flights list https://openlayers.org/en/v4.6.5/examples/data/openflights/flights.json can be used .
Purpose of this project was learning geoserver,openlayers and REST architecture and implementing them in a small demo.
This project is done for educational purposes and it contains changed versions of some of the openlayers examples that found on web.