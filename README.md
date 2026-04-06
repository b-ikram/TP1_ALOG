# TP1 ALOG - Conception d'un Interpréteur de Calculatrice Modulaire

Ce projet porte sur la conception architecturale d'une calculatrice extensible utilisant le **Design Pattern Interpreter**. Il est divisé en deux modules principaux pour assurer une haute cohésion et un faible couplage.


 ## Students

- **Chattah Salsabila** — ms_chattah@esi.dz
- **Badaoui Ikram** — mi_badaoui@esi.dz


## Architecture du Système

L'application repose sur deux piliers majeurs :

1.  **interpreter-lib** : La bibliothèque cœur qui implémente la grammaire.
    * `core` : Moteur de base.
    * `terminal` : Expressions de base (nombres/variables).
    * `nonterminal` : Opérations complexes (addition, multiplication, etc.).
2.  **calculator** : L'application cliente utilisant la bibliothèque.
    * `service` : Logique de coordination.
    * `gui` : Interface utilisateur (Graphique).
    * `trace` : Gestion des logs et du suivi de l'exécution.

## Structure du Dépôt
```text
.
├── calculator/           # Module Application
│   ├── src/td1/          # Code source (GUI, Service, Trace)
│   └── data/             # Fichiers de configuration ou données
├── interpreter-lib/      # Bibliothèque d'interprétation
│   └── src/td1/          # Implémentation du Pattern Interpreter
└── build/                # Fichiers compilés

