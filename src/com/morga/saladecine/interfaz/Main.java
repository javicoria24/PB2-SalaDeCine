package com.morga.saladecine.interfaz;

import java.util.Scanner;

import com.morga.saladecine.Asiento;
import com.morga.saladecine.Pelicula;
import com.morga.saladecine.PeliculaAccion;
import com.morga.saladecine.PeliculaComedia;
import com.morga.saladecine.PeliculaDrama;
import com.morga.saladecine.PeliculaInfantil;
import com.morga.saladecine.PeliculaTerror;
import com.morga.saladecine.SalaCine;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SalaCine sala;
    private static Pelicula[] peliculas = new Pelicula[10];
    
    public static void main(String[] args) {
        inicializarSistema();
        mostrarMenuPrincipal();
    }
    
    private static void inicializarSistema() {
        System.out.println("🎬 BIENVENIDOS AL SISTEMA DE GESTIÓN DE CINEMA 🎬");
        System.out.print("Ingrese el número de filas de la sala: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la sala: ");
        int columnas = scanner.nextInt();
        
        sala = new SalaCine(filas, columnas);
        
        // Cargar las 10 películas por defecto
        cargarPeliculasDefault();
        
        System.out.println("\n✅ Sistema inicializado correctamente!");
        System.out.println("Sala de " + filas + "x" + columnas + " creada exitosamente.");
        System.out.println("📽️  " + peliculas.length + " películas cargadas en el sistema.\n");
    }
    
    private static void cargarPeliculasDefault() {
        // Películas de Acción
        peliculas[0] = new PeliculaAccion("Misión Imposible", 150, 13);
        peliculas[1] = new PeliculaAccion("John Wick 4", 169, 16);
        peliculas[2] = new PeliculaAccion("Top Gun: Maverick", 130, 13);
        
        // Películas de Comedia
        peliculas[3] = new PeliculaComedia("La Máscara", 120, 7);
        peliculas[4] = new PeliculaComedia("Shrek", 90, 0);
        
        // Películas de Drama
        peliculas[5] = new PeliculaDrama("Forrest Gump", 142, 13);
        peliculas[6] = new PeliculaDrama("El Padrino", 175, 16);
        
        // Películas de Terror
        peliculas[7] = new PeliculaTerror("El Conjuro", 112, 16);
        peliculas[8] = new PeliculaTerror("Scream", 111, 18);
        
        // Película Infantil
        peliculas[9] = new PeliculaInfantil("Frozen", 102, 0);
    }
    
    private static void mostrarMenuPrincipal() {
        int opcion;
        
        do {
            System.out.println("=".repeat(50));
            System.out.println("🎭 MENU PRINCIPAL - GESTIÓN DE SALA DE CINE 🎭");
            System.out.println("=".repeat(50));
            System.out.println("1. 🎬 Gestionar películas");
            System.out.println("2. 🎫 Vender boleto");
            System.out.println("3. 🔓 Liberar asiento");
            System.out.println("4. 👀 Ver estado de la sala");
            System.out.println("5. 📋 Ver información de película actual");
            System.out.println("6. 👥 Ver detalle de compradores");
            System.out.println("7. 🎪 Reiniciar sala (liberar todos los asientos)");
            System.out.println("0. 🚪 Salir del sistema");
            System.out.println("=".repeat(50));
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    gestionarPeliculas();
                    break;
                case 2:
                    venderBoleto();
                    break;
                case 3:
                    liberarAsiento();
                    break;
                case 4:
                    mostrarButacas(sala);

                    break;
                case 5:
                    mostrarInfoPelicula();
                    break;
                case 6:
                    mostrarButacasDetalle(sala);
                    break;
                case 7:
                    reiniciarSala();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar nuestro sistema de cinema! 🍿");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intente de nuevo.");
            }
            
            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            }
            
        } while (opcion != 0);
    }
    
    private static void mostrarButacasDetalle(SalaCine sala2) {
    	Asiento[][] butacas = sala2.getButacas();
    	for (int i = 0; i < butacas.length; i++) {

			for (int j = 0; j < butacas[0].length; j++) {
				if (butacas[i][j].estaOcupado()) {
				 butacas[i][j].getNombreComprador();
				}

			}

		}
		
	}

	private static void gestionarPeliculas() {
        System.out.println("\n🎬 CATÁLOGO DE PELÍCULAS DISPONIBLES");
        System.out.println("=".repeat(50));
        
        for (int i = 0; i < peliculas.length; i++) {
            String genero = obtenerGenero(peliculas[i]);
            System.out.printf("%2d. [%s] %s (%d años+)\n", 
                (i + 1), genero, peliculas[i].getTitulo(), peliculas[i].getEdadMinima());
        }
        
        System.out.println("11. 📋 Ver sinopsis de película actual");
        System.out.println("=".repeat(50));
        System.out.print("Seleccione una película (1-11): ");
        
        int opcion = scanner.nextInt();
        
        if (opcion >= 1 && opcion <= 10) {
            Pelicula peliculaSeleccionada = peliculas[opcion - 1];
            sala.cambiarPelicula(peliculaSeleccionada);
            peliculaSeleccionada.mostrarSinopsis();
        } else if (opcion == 11) {
            if (sala.getPeliculaActual() != null) {
                sala.getPeliculaActual().mostrarSinopsis();
            } else {
                System.out.println("❌ No hay película en cartelera actualmente.");
            }
        } else {
            System.out.println("❌ Opción inválida.");
        }
    }
    
    private static String obtenerGenero(Pelicula pelicula) {
        if (pelicula instanceof PeliculaAccion) return "ACCIÓN";
        if (pelicula instanceof PeliculaComedia) return "COMEDIA";
        if (pelicula instanceof PeliculaDrama) return "DRAMA";
        if (pelicula instanceof PeliculaTerror) return "TERROR";
        if (pelicula instanceof PeliculaInfantil) return "INFANTIL";
        return "GENERAL";
    }
    
    private static void venderBoleto() {
        if (sala.getPeliculaActual() == null) {
            System.out.println("❌ No hay película en cartelera. Primero seleccione una película.");
            return;
        }
        
        System.out.println("\n🎫 VENTA DE BOLETOS");
        System.out.println("Película actual: " + sala.getPeliculaActual().getTitulo());
        System.out.println("Edad mínima requerida: " + sala.getPeliculaActual().getEdadMinima() + " años");
        
        sala.getButacas();
        
        System.out.print("Ingrese el nombre del comprador: ");
        scanner.nextLine(); // Limpiar buffer
        String nombreComprador = scanner.nextLine();
        
        System.out.print("Ingrese la fila del asiento: ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese la columna del asiento: ");
        int columna = scanner.nextInt();
        System.out.print("Ingrese la edad del cliente: ");
        int edad = scanner.nextInt();
        
        boolean exito = sala.venderBoleta(fila, columna, edad, nombreComprador);
        
        if (exito) {
            System.out.println("🎉 ¡Boleto vendido exitosamente!");
            sala.getButacas();
        } else {
            System.out.println("❌ No se pudo vender el boleto.");
        }
    }
    
    private static void liberarAsiento() {
        System.out.println("\n🔓 LIBERAR ASIENTO");
        sala.getButacas();
        
        System.out.print("Ingrese la fila del asiento a liberar: ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese la columna del asiento a liberar: ");
        int columna = scanner.nextInt();
        
        boolean exito = sala.liberarAsiento(fila, columna);
        
        if (exito) {
            System.out.println("🎉 ¡Asiento liberado exitosamente!");
            sala.getButacas();
        }
    }
    
    private static void mostrarInfoPelicula() {
        if (sala.getPeliculaActual() != null) {
            System.out.println("\n📋 INFORMACIÓN DE LA PELÍCULA ACTUAL");
          //if(obtenerGenero(sala.getPeliculaActual()).equalsIgnoreCase("ACCION"))
            	
            	
            
            
            sala.getPeliculaActual().mostrarSinopsis();
        } else {
            System.out.println("❌ No hay película en cartelera actualmente.");
        }
    }
    
    private static void reiniciarSala() {
        System.out.print("⚠️  ¿Está seguro que desea liberar todos los asientos? (s/n): ");
        scanner.nextLine(); // Limpiar buffer
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("s") || confirmacion.equalsIgnoreCase("si")) {
            sala.reiniciarSala();
            sala.getButacas();
        } else {
            System.out.println("❌ Operación cancelada.");
        }
    }
    
    public static void mostrarButacas(SalaCine sala) {
    	Asiento[][] butacas = sala.getButacas();
    	
    	System.out.println("\n=== ESTADO DE LA SALA ===");
        if (sala.getPeliculaActual() != null) {
            System.out.println("🎬 Película: " + sala.getTitulo());
        }
        System.out.println("📊 Ocupación: " + sala.contarAsientosOcupados() + "/" + sala.getTotalAsientos() + " asientos");
        System.out.print("   ");
        for (int j = 0; j < butacas[0].length; j++) {
            System.out.printf("%3d", j);
        }
        System.out.println();
        
        for (int i = 0; i < butacas.length; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < butacas[i].length; j++) {
                char estado = butacas[i][j].estaOcupado() ? 'X' : 'O';
                System.out.printf("%3c", estado);
            }
            System.out.println();
        }
        System.out.println("O = Libre, X = Ocupado\n");
    }

    public void cambiarPelicula(Pelicula nuevaPelicula) {
    	sala.cambiarPelicula(nuevaPelicula);
    	System.out.println("Pelicula cambiada a: " + nuevaPelicula.getTitulo());
    }

}