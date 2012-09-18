#!/usr/bin/python
#-*- coding: utf-8 -*-


import random

def generar_tablas(archivo):
    ruta = "./scriptTablas.sql"
    f = open (ruta)
    linea = f.readline()
    while linea:
        archivo.write(linea)
        linea = f.readline()
    f.close()

def generar_usuarios(archivo):
    lista_nombres = ["David", "Jorge", "Sergio", "Jesus", "Rodrigo", "Gabriel", "Javier", "Roberto", "Payaso", "Cacho", "Mourinho", "Guardiola"]
    lista_apellidos = ["Perez", "Merino", "Monda", "Alises","Garcia","Zaba","Manzano","Testillano","Tordesillas","Stallman","Gates","Jobs"]
    lista_direcciones = ["Calle Azucena", "Calle Toledo","Avenida de Europa","Avenida de Barber","Avenida de la Reconquista","Calle Santo Tome","Calle Bachiller Fernan Gomez"]
    lista_passwords = ["111111"]
    lista_correos = []
    for nombre in lista_nombres:
        lista_correos.append(nombre + "@iso2.com")

    # Escribimos los admins..
    numero_admin = 2
    lista_correos_admin = []
    admin_introducidos = 0
    lista_correos_admin = lista_correos[-numero_admin:]

    
    # Escribimos los clientes
    numero_clientes = len(lista_nombres)-numero_admin
    lista_correos_clientes = []
    clientes_introducidos = 0
    for correo in lista_correos:
        if clientes_introducidos < numero_clientes:
            lista_correos_clientes.append(correo)
            clientes_introducidos += 1

    
    # Escribimos el fichero
    # Escribimos los usuarios        
    for i in range(len(lista_correos)):
        f.write("INSERT INTO Usuario VALUES ('" + lista_correos[i] + "', '" + random.choice(lista_passwords) + "', '" + lista_nombres[i] + "', '" +  random.choice(lista_apellidos) + "');\n")
    
    # Escribimos los clientes
    for i in range(len(lista_correos_clientes)):
        f.write("INSERT INTO Cliente VALUES ('" + lista_correos_clientes[i] + "', '" + random.choice(lista_direcciones) +"');\n")

    # Escribimos los admins
    for i in range(len(lista_correos_admin)):
        f.write("INSERT INTO Administrador VALUES ('" + lista_correos_admin[i] + "');\n")
     
    return lista_correos_clientes

def generar_productos(archivo):
    
    lista_descripciones = ["El mejor calcetin", "La mejor pantalla", "Nada", "El mejor jersey", "El mejor pantalon", "El mejor camiseta", "La peor camiseta"]
    ruta_imagen = "img/"

    lista_categorias = ["Motos", "Zapatillas", "Camisetas","Bicicletas","Electrodomesticos","Ordenadores","Linternas","Moviles"]

    lista_motos=["Honda cb 250","Piaggio zip","Piaggio zip compressor","Yamaha Aerox","Suzuki Burgmann","Aprilia Rally","Ninja","Harley Davidson 1000","Montesa 50"]
    lista_zapatillas=["Puma sprint", "Totan 90","Nike 90","Adidas 60","Botas de campo","Chanclas playeras","Sandalias de cuero","Converse de toda la vida","Converse Star"]
    lista_camisetas=["Converse normal","Converse sport","Converse Love","Camiseta de cuello alto","Camiseta casual","Adidas Portero","Nike Rugby","Puma futbol","Quicksilver sport"]
    lista_bicicletas=["Ciudad Mujer 65","Ciudad Mujer 70","Ciudad Mujer 75","Ciudad Mujer sin barra centro","Ciudad Hombre 70","Campo Hombre 70","Ciudad Hombre 75","BMX unisex mini","BMX Pro"]
    lista_electrodomesticos=["Lavadora Fagor 5 kg","Lavadora Bosch 7 kg","Microondas 2000 w","Microondas 1000 w","Fregaplatos Bosch","Labavajillas Balay","Lavadora Fagor 7 kg","Tostador Sandwichera"]
    lista_ordenadores=["Dell Vostro 1000","Dell Vostro 1500", "Dell Adamo","Dell v13","Dell Inspiron 1500","Dell Inspiron 15z", "Dell Inspiron 14z","Dell Streak","Dell Optiplex 1000","Dell XPS 15"]
    lista_linternas=["Linterna simple","Linterna solar","Linterna 3 led","Linterna xenon","Linterna multiusos","Linterna de cabeza"]
    lista_moviles=["Dell Streak","Motorola Defy","Motorola Defy +","HTC Legend","HTC Desire HD","LG a170","Nokia Luma 800","Iphone 4s","Iphone 4","Geekphone"]

    lista_listas=[lista_motos,lista_zapatillas,lista_camisetas,lista_bicicletas,lista_electrodomesticos,lista_ordenadores,lista_linternas,lista_moviles]

    lista_stocks = [2000, 30, 20, 100,300,400,15,150]
    
    cont=0
    for i in range(len(lista_listas)):
        for j in range (len(lista_listas[i])):
            cont+=1
            archivo.write("INSERT INTO Producto VALUES ('" + str(cont) + "', '" + lista_listas[i][j] + "', '" + str(random.randint(lista_stocks[i],lista_stocks[i]*11)/5) + "', '" + lista_categorias[i] + "', '" + random.choice(lista_descripciones) + "', '" + ruta_imagen+lista_categorias[i]+".jpeg" + "', '" + str(random.randint(cont,cont*2)) + "');\n")

def generar_pedidos(archivo, lista_clientes):
    lista_fechas = ["2012/12/12", "2001/01/01", "2011/11/24","2011/11/10","2011/11/22","2011/11/20","2011/11/23","2011/11/11","2011/11/15"]
    lista_precios = ["3.0", "321.60", "429.98", "59.59"]
    for fechas in lista_fechas:
        archivo.write("INSERT INTO Pedido (fecha, cliente, precio) VALUES ('" + fechas + "', '" + random.choice(lista_clientes) + "', '" + random.choice(lista_precios) + "');\n")
    return len(lista_fechas)

def generar_paquete_productos(archivo, longitud):
    lista_descripciones = ["El mejor calcetin", "La mejor pantalla", "Nada", "El mejor jersey", "El mejor pantalon", "El mejor camiseta", "La peor camiseta"]
    lista_precios = ["3.0", "321.60", "429.98", "59.59"]
    lista_motos=["Honda cb 250","Piaggio zip","Piaggio zip compressor","Yamaha Aerox","Suzuki Burgmann","Aprilia Rally","Ninja","Harley Davidson 1000","Montesa 50"]
    for i in range(longitud):
        archivo.write("INSERT INTO PaqueteProducto VALUES ('" + str(i) + "', '" + str(i) + "', '" + str(random.randint(1,10))+ "', '" + random.choice(lista_motos) + "', '" + random.choice(lista_descripciones) + "', '" + random.choice(lista_precios) + "');\n")

if __name__ == "__main__":
    f = open("datosdb.txt", "w")
    generar_tablas(f)
    lista_clientes = generar_usuarios(f)
    generar_productos(f)
    longitud = generar_pedidos(f, lista_clientes)
    generar_paquete_productos(f, longitud)
    f.close()
