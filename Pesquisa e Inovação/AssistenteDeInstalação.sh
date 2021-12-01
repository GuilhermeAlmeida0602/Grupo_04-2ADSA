#!/bin/bash

echo "======================================================="
echo " "
figlet InfoSystem || echo "InfoSystem"
echo " "
echo "======================================================="
echo " "

echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) :  Bem-vindo ao nosso assistente de instalação"
echo " "

echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) :  Iremos instalar os pacotes necessarios para a inicialização da aplicação"
echo " "

echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) :  Fique ligado!! terá algumas interações para digita Y/N (Yes or No) ou S/N (Sim ou Não) se caso estiver em português"
echo " "

echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Antes de tudo, vamos atualizar seus pacotes"
echo " "
echo " "
echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Podemos começar?"
echo "1 - SIM"
echo "2 - Não"
read comecar

if [ "$comecar" -eq "1" ];
then

sudo apt-get update
sudo apt-get upgrade

echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Opa, tudo atualizado "

else

exit

fi

echo " "
echo " "

echo " -----------------------------------------------------------------------"
echo " "
echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Instalando o java (Se ja estiver instalado ele irá mostrar a versão)"
echo " "
echo " -----------------------------------------------------------------------"
java -version || sudo apt-get install default-jdk

echo " "
echo " "

echo " -----------------------------------------------------------------------"
echo " "
echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Instalando o maven (Se ja estiver instalado ele irá mostrar a versão)"
echo " "
echo " -----------------------------------------------------------------------"
mvn -version || sudo apt install maven

echo " "
echo " "
echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Está quase tudo pronto agora iremos instalar nossa aplicação"
echo " "
echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : No meio da instalação será criada uma pasta para onde terá nossos arquivos"

git clone https://github.com/guilhermesilvafonseca/TotemSoluction.git

cd TotemSoluction

echo " "
echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Agora estamos nesse caminho do seu computador "
pwd

echo " "
echo "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) : Deseja iniciar nosso programa?"
echo "1 - SIM "
echo "2 - NÃO"
read ini

if [ "$ini" -eq "1" ];
then
java -jar TotemSoluction.jar
else
exit
fi
