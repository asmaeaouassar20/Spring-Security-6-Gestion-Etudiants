## Confiuration automatique de Spring Boot pour Spring Security
Spring Security configure automatiquement les fonctionnalités suivantes:
- **Starter** ```spring-boot-starter-security``` : regroupe les dépendances liées à Spring Security.
- **Activation de la configuration par défaut de Spring Security** : crée un **filtre servlet** sous forme de bean nommé ```springSecutityFilterChain```. Fournit un formulaire de connexion par défaut.
- **Création d'un utilisateur par défaut** : un nom d'utilisateur par défaut (```user```) et un mot de passe généré aléatoirement qui est affiché dans la console.
- Spring Boot offre des propriétés pour personnaliser le nom d'utilisateur t le mot de passe par défaut.
- **Protection du stockage des mots de passe** : utilise l'algorithme BCrypt.
- **Déconnexion de l'utilisateur** : inclut une fonctionnalité de déconnexion par défaut.
- **Prévention des attaques CSRF** : activée par défaut.
- Si Spring Security est présent dans le classpath, Spring Boot sécurise automatiquement tous les points de terminaison HTTP avec une authentification "basique".
