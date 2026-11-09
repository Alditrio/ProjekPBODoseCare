#!/usr/bin/env bash
set -e
cd "$(dirname "$0")"
mkdir -p bin

echo "Mengkompilasi ProjekPBODoseCare..."
javac -encoding UTF-8 -d bin *.java

echo "Menjalankan ProjekPBODoseCare..."
java -Dfile.encoding=UTF-8 -cp bin Main
