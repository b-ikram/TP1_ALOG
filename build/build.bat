@echo off

:: 1. Création des dossiers nécessaires s'ils n'existent pas
if not exist build mkdir build
if not exist interpreter-lib\bin mkdir interpreter-lib\bin
if not exist calculator\bin mkdir calculator\bin

echo Generation des listes de sources...
:: Utilisation de PowerShell pour lister les fichiers .java proprement
powershell -Command "Get-ChildItem -Path 'calculator\src\*.java' -Recurse | Select-Object -ExpandProperty FullName" > build\sources-app.txt
powershell -Command "Get-ChildItem -Path 'interpreter-lib\src\*.java' -Recurse | Select-Object -ExpandProperty FullName" > build\sources-lib.txt

echo Compilation...
:: Compilation de la lib
javac -d interpreter-lib/bin @build/sources-lib.txt

:: Compilation de l'app (on pointe vers le bin de la lib pour le classpath)
javac -d calculator/bin -cp "interpreter-lib/bin" @build/sources-app.txt

echo.
echo ======================================================
echo  BUILD REUSSI ! 
echo ======================================================
java -cp "calculator/bin;interpreter-lib/bin" td1.calculator.Main
pause