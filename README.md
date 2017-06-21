# Documentation

## Gradle build system

### Gradle ?
Un projet Android Studio s'axe autour de l'outil gradle pour gérer l'ensemble du cycle de vie d'une création d'application depuis des sources existantes.


Par convention, il est dit qu'un projet contient 1 ou plusieurs modules. Par défaut, en créant une application, Android Studio va créer une racine contenant les descriptifs gradle (build.gradle) et un module "app" lui-même contenant des directives build.gradle

Dans le module app, build.gradle décrit le type de module qui est "logiquement" une "application". Il pourrait néanmoins s'agir de bibliothèques, etc...

### Constitution type d'un build.gradle de module applicatif

Un fichier de compilation gradle contient :

- une entête ou obtenir les dépendances nécessaires pour le module ou les étapes de compilation
- le type de module
- pour Android, un bloc décrivant les options nécessaires & modes pour les outils externe
- potentiellement des outils externes comme des processeurs d'annotations
- le bloc des dépendances du projet (les bibliothèques comme le support android, DBFlow, Fabric/Crashlytics, les analytics etc...

### Dépendances

Dans la quasi totalité des cas, les bibliothèques intégrables dans les projets vont se borner à ajouter dans le bloc de dépendances :

```
dependencies { // ce bloc existe déjà
...
compile "domain.name:library-name:version"
...
} //</>
```

Des subtitlités peuvent apparaître mais il sera largement usuel, là aussi, de trouver des snippets ("morceaux") de code dans la documentation de la dite bibliothèque pour modifier le build.gradle en cas de modifications plus importantes.


Exemple; DBFlow nécessite qu'un processeur d'annotation s'exécute pour abstraire complètement la gestion SQLite au sein de l'application.


## Versioning imposé

### Principe

L'architecture de version proposé permet de favoriser une communication & une clarté dans l'organisation du développement de l'application.

Un socle de base est disponible pour tous les groupes. Dans chaque groupe, un des membres est chargé de "forker" le socle.
A chaque mise à jour du socle, il est désigné pour intègrer les modifications dans le projet du groupe mais aussi de centraliser toutes les modifications des autres membres du groupe qui doivent dès lors passer une "pull request" afin de livrer leurs commits aux autres membres

Par défaut, git défini pour chaque clone du projet comme étant l'url github du projet hébergé.
On notera "upstream", l'url correspond au projet "parent" qui a été forké et sur lequel les modifications seronts poussées en pull request

```
#e.g. :
git remote add upstream https://github.com/<nickname>/BaseCodeCesi
```

### Une mise à jour du socle est disponible


Le membre du groupe désigné précédemment effectue :

- un stash* des modifications non commitées actuellement
- un pull des modifications du "upstream"
- un push sur "origin" (son propre clone!) des modifications
- un stash apply des modifications non commitées précédemment "stashées"
- résolution des possibles conflits notés CONFLICT en CLI ou affichés "error" sous Android Studio
- compilation pour tester au minima la création d'un apk ou lancement sur un device

Ensuite, chaque membre du groupe va appliquer la même logique étant donné que upstream pointe sur le projet maintenant à jour sur le github du membre désigné.

### Un membre du groupe veut partager ses modifications

- préparation du dernier commit à envoyer (plusieurs commits peuvent être créé avant de push! selon les besoins)
- stash des sources qui sont "en cours" (si réellement eu besoin) d'édition mais qui ne doivent pas être émises
- pull du upstream du projet si le membre n'est pas celui désigné pour partager le socle
- résolution des conflits possibles (et création du commit de merge)
- push des commits sur origin! et non upstream
- stash apply pour appliquer les modifications qui étaient en attente d'être stables
- résolution des possibles conflits avec les sources stashées
- via github, création d'une pull request du projet forké VERS le projet upstream (ticket)
- à la validation par le membre du groupe / consensus du groupe via Slack, ne pas oublier de dire aux membres de puller les modifications

### Stash ? Stash apply ?

Stasher avec git permet de sauvegarder dans un espace "temporaire" toutes les modifications faites sur des fichier du projet pour notamment pouvoir travailler sur un synchro avec ce qui a déjà été validé en amont.

Un stash apply va permettre de charger toutes ses modifications "sauvegardées" dans le projet actuel et tenter de les merger avec le contenu courant.

Il peut y avoir des conflits résolvables exactement de la même manière qu'en synchronisant son projet local avec un upstream ayant mis à jour par un autre utilisateur

```
git stash
git stash apply
```

## Version du socle

v0.0.1 : en cours de création...

v0.0.0 : initial commit
