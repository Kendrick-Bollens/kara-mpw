# mgse-kara
Dies ist eine Umwandlung des Projektes (MPW-Hamster)[https://github.com/SQAHamster/mpw-modeling-hamster] auf "Kara der Marienkäfer"  um zu testen wie leicht es wäre es zu erweitern

## Aufsetzen

Zum Aufsetzen des Projektes in der Entwicklungsumgebung werden 3 dinge benötigt:

- Eclipse moddeling framework (EMF) [Downloadseite](https://www.eclipse.org/downloads/packages/release/2022-12/r/eclipse-modeling-tools) 
- JDK 15 [Downloadseite](https://jdk.java.net/archive/) 
- Dieses Projekt

### 1. EMF einrichten

1. EMF installieren
2. EMF starten und einen geeigneten ort für den Workspace wählen
3. Projekt Herunterladen und integrieren
Hier sind zwei Wege über die dies erreicht werden kann
    *  Git-Client des vertrauens Vetrauens verwenden
        1. Projekt über den Git-Client des vertrauens herunterladen
        2. Projekt in EMF laden über "File / Import / Maven / Existing Maven Projects"
        3. Pfad angeben des Projektes angeben 
        4. "Finish" Button klicken
    * EMF Git-Integration verwenden
        1. Projekt herunterladen über "File / Import / Git / Projects from Git" (Tipp ist es den link schon kopiert zu haben befor ausgeführt)
        2. Clone URI
        3. Pfade angeben
        4. "Finish" Button klicken
4. Installation der EMF Integrationen
    1. Integrationen über Datei installieren "File / Import / Install / Install Software Items from File"
    2. Pfad zur Datei "installed-items.p2f" im Root des Projektes angeben
    3. "Select All" Button klicken
    4. "Finish" Button klicken 
    5. warten bis alles installiert ist "kann in der unteren rechten Ecke beobachtet werden"
5. JDK auf Java 15 ändern
    1. Einstellung von Javapfad abändern "Window / Preferences / Java / Installed JREs"
    2. "Add" Button klicken
    3. "Standard VM" angeben und "Next" Button klicken
    4. über "Directory" Button Verzeichniss von JDK 15 angeben
    5. "Finish" Button klicken
    6. Haken in die neu angezeigte JDK setzen
    7. mit "Apply and Close" Button fenster schließen
6. Aktivieren der Target plattform
    1. Datei "targetplattform.target" unter de.unistuttgart...targetplattform öffnen
    2. auf "Set as Active Target Plattform" in der oberen rechten ecke klicken
    3. warten bis in der unteren rechten ecke es fertig geladen ist
    3. einzeln auf die einträge in Locations klicken, warten bis welche selected sind und auf den "Finish" Button klicken
7. Projekt ausführen und code generieren.
    1. rechtsklicken auf hamster-modeling-root
    2. "Run As / Maven Install" anklicken

## Eigens Programmierte UI
Repo für die UI: https://github.com/meekhrc/Kara-generated-gui
