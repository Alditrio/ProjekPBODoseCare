@echo off
setlocal
chcp 65001 >nul
title ProjekPBODoseCare - Pemrograman Berorientasi Objek

cd /d "%~dp0"
if not exist "bin" mkdir "bin"

echo ========================================================
echo   Mengkompilasi ProjekPBODoseCare...
echo ========================================================

javac -encoding UTF-8 -d "bin" *.java

if errorlevel 1 (
    echo.
    echo [ERROR] Kompilasi gagal! Pastikan JDK terpasang.
    pause
    exit /b 1
)

cls
java -Dfile.encoding=UTF-8 -cp "bin" Main
if errorlevel 1 (
    pause
)
endlocal
