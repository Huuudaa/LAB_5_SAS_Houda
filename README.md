# TP Convertisseur Pro — Application Android à Onglets

## Description

Application Android simple démontrant l'utilisation des onglets (TabLayout et ViewPager2) avec deux fragments : un pour convertir les températures (°C ↔ °F), et un autre pour convertir les distances (Km ↔ Miles). L'application intègre également un menu "Fermer" et une confirmation à la touche Retour.

---

## Fonctionnalités

- Navigation entre deux onglets : **"Chaleur"** et **"Distance"**
- Conversion Celsius ↔ Fahrenheit avec formule mathématique
- Conversion Kilomètres ↔ Milles avec facteur de conversion
- Validation des champs de saisie (message Toast si vide)
- Menu "Fermer" dans la barre d'action
- Dialogue de confirmation avant de quitter (touche Retour ou menu)

---

## Fichiers principaux

### `activity_main.xml`
Layout principal contenant :

| Composant   | ID                  | Rôle                        |
|-------------|---------------------|-----------------------------|
| TabLayout   | tabLayoutPrincipal  | Barre d'onglets             |
| ViewPager2  | pagerPrincipal      | Conteneur des fragments     |

### `fragment_chaleur.xml`
Layout du fragment de température contenant :

| Composant    | ID                | Rôle                              |
|--------------|-------------------|-----------------------------------|
| RadioGroup   | rgTemperature     | Groupe de boutons radio           |
| RadioButton  | rbCtoF            | Sélection Celsius → Fahrenheit    |
| RadioButton  | rbFtoC            | Sélection Fahrenheit → Celsius    |
| EditText     | etValeurChaleur   | Champ de saisie de la valeur      |
| Button       | btnConvertirChaleur | Déclenche la conversion         |
| TextView     | tvResultatChaleur | Affiche le résultat               |

### `fragment_distance.xml`
Layout du fragment de distance contenant :

| Composant    | ID                  | Rôle                          |
|--------------|---------------------|-------------------------------|
| RadioGroup   | rgDistance          | Groupe de boutons radio       |
| RadioButton  | rbKmToMiles         | Sélection Km → Miles          |
| RadioButton  | rbMilesToKm         | Sélection Miles → Km          |
| EditText     | etValeurDistance    | Champ de saisie de la valeur  |
| Button       | btnConvertirDistance | Déclenche la conversion      |
| TextView     | tvResultatDistance  | Affiche le résultat           |

### `MainActivity.java`
Logique principale de l'application :
- TabLayout et ViewPager2 pour la navigation par onglets
- TabLayoutMediator pour lier les onglets aux fragments
- `onCreateOptionsMenu` pour ajouter le menu "Fermer"
- `OnBackPressedDispatcher` pour intercepter la touche Retour
- `AlertDialog` pour confirmer la fermeture

### `FragmentPagerAdapter.java`
Adaptateur gérant les deux fragments :
- `createFragment()` retourne `ChaleurFragment` ou `DistanceFragment`
- `getItemCount()` retourne 2 (nombre d'onglets)

### `ChaleurFragment.java`
Logique de conversion des températures :
- Récupération de la valeur saisie
- Validation du champ (non vide)
- Calcul selon le bouton radio sélectionné
- Affichage du résultat avec 2 décimales

### `DistanceFragment.java`
Logique de conversion des distances :
- Récupération de la valeur saisie
- Validation du champ (non vide)
- Calcul selon le bouton radio sélectionné
- Affichage du résultat avec 2 décimales

---

## Formules de conversion

| Conversion               | Formule                        |
|--------------------------|--------------------------------|
| Celsius → Fahrenheit     | °F = (°C × 9/5) + 32          |
| Fahrenheit → Celsius     | °C = (°F − 32) × 5/9          |
| Kilomètres → Milles      | milles = km × 0.621371         |
| Milles → Kilomètres      | km = milles × 1.609344         |

---

## Concepts utilisés

| Concept                    | Description                                                        |
|----------------------------|--------------------------------------------------------------------|
| Fragment                   | Composant réutilisable représentant une partie de l'interface      |
| TabLayout                  | Barre d'onglets pour naviguer entre fragments                      |
| ViewPager2                 | Permet de swiper horizontalement entre fragments                   |
| TabLayoutMediator          | Lie le TabLayout au ViewPager2                                     |
| FragmentStateAdapter       | Adaptateur pour gérer les fragments                                |
| RadioGroup / RadioButton   | Permet de choisir le sens de conversion                            |
| EditText                   | Champ de saisie avec `inputType="numberDecimal"`                   |
| AlertDialog                | Dialogue de confirmation avant de quitter                          |
| OnBackPressedDispatcher    | Gestion moderne de la touche Retour                                |
| Toast                      | Message temporaire pour les erreurs                                |
| TextUtils.isEmpty()        | Vérifie si le champ est vide                                       |
| String.format(Locale, ...) | Formate les nombres avec 2 décimales                               |

---

## Environnement

- **IDE :** Android Studio
- **Langage :** Java
- **API cible :** 36.1
- **Émulateur :** Medium Phone API 36.1
