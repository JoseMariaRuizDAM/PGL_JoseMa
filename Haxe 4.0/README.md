<div align= "justify">
    
# HAXE 4
![alt_text](../pgl/unnamed.jpg)

[TOC]
# Introducción

El repositorio que leerás a continuación está creado para presentar el Desarrollo Cross-platform Haxe 4. 

En esta presentación, se añadirán preguntas básicas como, ¿Qué es? ¿Cómo instalar el Haxe 4 en diferentes sistemas operativos? ¿Requisitos mínimos? Además de integrar un ejemplo básico.


## ¿Qué es Haxe 4?

Cuando hablamos de Haxe, debemos entender que se trata de un lenguaje de programación de código abierto de alto nivel, y además es un compilador orientado sobre todo al 2D.

En su web oficial mencionan que se usa mucho para la creación de APIs, aplicaciones web y de escritorio, pero para lo que más se suele usar es para la creación de videojuegos.

Al ser capaz de ejecutarse en numerosos dispositivos. Este lenguaje de programación es muy utilizado para la creación de juegos móviles, como bien he indicado anteriormente, pero también es capaz de crear aplicaciones en php, Python, Java, HTML5 o Flash.

Entonces, la idea general aquí es que se trata de "un lenguaje para gobernarlos a todos". Por lo que puedes escribir una aplicación en Haxe, luego se compila en otro lenguaje para apuntar a una plataforma. Básicamente, trata el lenguaje de salida (como JavaScript, C#, Python, etc.) como código de bytes para tu aplicación.


![alt_text](../pgl/2.jpg)



## Ventajas y Desventajas de Haxe 4


### Ventajas

Una de las grandes ventajas de este motor orientado al 2D, es la facilidad de reducir recursos. Este desarrollador permite realizar juegos a 60 fotogramas por segundo y 1080p de manera simple y rápida. 

Otra de las ventajas que se puede añadir a Haxe 4, además de su velocidad y lo ligero que es, es que tiene una gran comunidad activa y permite compilar sus juegos en forma nativa a prácticamente todas sus plataformas, ya sea en Linux, iOS, Windows e incluso Android.


### Desventajas

Una de las principales desventajas, es que para los principiantes les cuesta su lenguaje de programación, ya que es muy estricto y tratar de modificar sus librerías puede traer muchos problemas a los inexpertos.

El uso para este motor es para usuarios avanzados, es realmente increíble el rendimiento y la capacidad de exportar nativamente que tiene, pero solo aquellos con conocimientos previos en los lenguajes de programación que se manejan en este motor de desarrollo para juegos 2D podrán aprovecharlo al máximo.


## ¿Lenguajes de programación que Soporta Haxe 4?


![alt_text](../pgl/3.png)


El código escrito en Haxe puede ser compilado a código fuente en Adobe Flash, Javascript, Lua, Python, C++, C#, Hashlink, Java y Neko (creado por el mismo desarrollador) y de lado del servidor en PHP,<sup> </sup>Apache CGI y Node.js. A continuación se muestra **una imagen con los lenguajes de programación**, tipo de salida (Output type), y sus principales usos (Main usages):


![alt_text](../pgl/4.png)



## Requisitos

Los requisitos mínimos para poder usar este motor de videojuegos en 2D, son los siguientes:



* Un IDE que acepte diferentes lenguajes de programación y se pueda instalar la extensión o plugin de Haxe. Por ejemplo, en mi caso, usare Visual Studio Code.
* Descargar el motor de desarrollo Haxe 4.0 o una versión anterior. ([Página oficial de descarga)](https://haxe.org/download/) .
* Tener conocimientos de lenguajes de programación, ya sea JavaScript, Python, C++, C#, Java, HTML5 ( Para aplicaciones en web, o incluso para móviles). 
* Tener un mínimo de conocimientos matemáticos.
* Creatividad para la combinación de colores y creación de formas (requisito que no es imprescindible, pero ayuda para la creación de nuevos proyectos).


## Instalación

Para poder instalar este motor de desarrollo de juegos en 2D, al ser multiplataforma, **se puede instalar tanto en Linux, en Windows como en dispositivos iOS**.


![alt_text](../pgl/5.png)



### Instalación de Haxe en Linux (Ubuntu)


```
sudo add-apt-repository ppa:haxe/releases -y
sudo apt-get update
sudo apt-get install haxe -y
mkdir ~/haxelib && haxelib setup ~/haxelib
```



### Instalación de Haxe en Windows

Para instalar Haxe 4 en Windows, puedes hacer la [descarga en la web oficial](https://haxe.org/download/). En mi caso, me he descargado el instalador de 64bits, aunque existen diferentes opciones como el binario o para 32 bits.


![alt_text](../pgl/6.png)


Una vez se haya descargado el instalador, le apretamos al archivo que **se ha descargado “.exe”**. El cual comenzará con el instalador:


![alt_text](../pgl/7.png)


En cuanto vayamos a instalar Haxe 4, también podemos instalar Neko, ya que viene dentro del instalador. Neko es **una máquina virtual** que ha creado el equipo de Haxe, para complementar y ser una herramienta más para Haxe.



![alt_text](../pgl/8.png)


Una vez le damos a siguiente, nos pregunta dónde queremos instalar el software y en cuanto le demos a aceptar, comenzará la instalación. Cuando esta termine, ya habrá finalizado todo y tendrás instalado Haxe 4 en windows y si has añadido Neko en la instalación, también estará en el ordenador.


### Desinstalar Haxe 4 Windows

Para desinstalar Haxe 4 en windows, debes de dirigirte a la carpeta donde lo tienes instalado y dentro de ella, encontrarás el archivo “uninstall.exe”.



![alt_text](../pgl/9.png)



## Como iniciar Haxe 4 o como usar en Windows

Para poder iniciar o usar Haxe 4, debemos de abrir una consola “cmd” y para comenzar, podemos escribir el comando haxelib, el cual nos mostrará todas las librerías de Haxe.

Luego debemos instalar Flixel:


```
haxelib install flixel
```

![alt_text](../pgl/10.png)


A continuación se escribe:


```
haxelib install openfl
```


![alt_text](../pgl/11.png)


El siguiente paso es:


```
haxelib run openfl setup
```



### Inicio con Visual Studio Code

Una vez ya instalado el Haxe y hecho los pasos en el CMD de windows, debemos de tener instalado Visual Studio Code (VSC) y buscar en las extensiones Haxe e instalar la extensión que se llama Haxe.

Luego de haber reiniciado el VSC se crea un nuevo proyecto con las teclas ctrl+shift+p y se escribe Haxe, y se presiona sobre nuevo proyecto.

Luego se escribe el codigo que queramos compilar. Se abre una nueva terminal y se ejecuta el programa con f5.

En este caso he corrido el programa, “Hola Mundo”

![alt_text](../pgl/12.png)



## Conceptos Básicos del lenguaje Haxe

La extensión de un programa en Haxe es *.hx. 

Aquí vemos un ejemplo de un Main en Haxe (Main.hx) con un Hola Mundo.


```
    class Main{
    static public function main(): Void{
    trace("Hola mundo!");
    }
    }
```


Para compilar y ejecutar en Linux, se debe de abrir una terminal y escribir lo siguiente:


```
    haxe --main Main --interp
```



### Tipos de datos en Haxe:


```
    var entero:Int=11;
    var cadena:String="Helmut Gerrsand";
    var falso:Bool= 45 > 21;
    var flotante:Float=3.4;
```


Funciones en Haxe:


```
    class Main{
    static public function main(): Void{
    testA();
    }
    static public function testA(): Void{
    trace("Hola mundo!");
    }
    }
```



## Juegos hechos con Haxe

[Dungeon of Gain alpha](https://www.youtube.com/watch?v=26-hg4OHlk8)
[Defender's Quest: Valley of the Forgotten DX](https://www.youtube.com/watch?v=QEarmXpMag8)
[ The Enchanted Cave 2 Premium Official Gameplay Trailer ](https://www.youtube.com/watch?v=UvBEr-L0HQY)

## Conclusión
Este motor de desarrollo es muy complejo a la hora de querer crear un juego, ya que no es apto para principiantes como otros motores de desarrollo de juegos en 2D. Esto es debido a que debes de tener conocimiento de código, aunque sea un lenguaje de programación.
    
    
</div>

