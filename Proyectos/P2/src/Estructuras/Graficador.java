package Estructuras;

import java.io.*;


public class Graficador {

	public void crearDot(Nodo primero, String nombre) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {					
			fw = new FileWriter(nombre);
			pw = new PrintWriter(fw);
			pw.println("digraph listadoble {  node[shape=record];");
			pw.println(generarDotListaAvion(primero));
			pw.println("}");
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	}
	
	public void crearDesabordaje(Nodo primero, String nombre) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(nombre);
			pw = new PrintWriter(fw);
			pw.println("digraph listaPasajeros { node[shape=record]; ");
			pw.println(generarDotDesabordaje(primero));
			pw.println("}");
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	}
	
	public void crearDotMantenimiento(Nodo primero,String nombre,Nodo cola) {
		FileWriter fw = null;
		PrintWriter pw = null;
	
		try {
			fw = new FileWriter(nombre);
			pw = new PrintWriter(fw);
			pw.println("digraph listaMantenimiento { node[shape=record]; ");
			pw.println("subgraph estacion{");
			pw.println(generarDotEstacion(primero));
			pw.println("rank = same" + rankEstacion(primero) + "}");
			pw.println("subgraph cola {" + generarDotColaAvion(cola) + "}");
			pw.println(mantEst(primero,cola) + "}");
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	
	}
	
	public void crearDotListaMaleta(Nodo primero, Nodo ultimo, String nombre) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(nombre + ".dot");
			pw = new PrintWriter(fw);
			pw.println("digraph listacircular {");
			pw.println(generarDotListaMaleta(primero,ultimo));
			pw.println("}");
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	}
	
	public void crearDotEscritorio(Nodo primero, String nombre) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(nombre);
			pw = new PrintWriter(fw);
			pw.println("digraph listaEscritorio { node[shape=record]; ");
			pw.println("subgraph escritorio{");
			pw.println(generarDotEscritorio(primero));
			pw.println("rank = same " + rankEscritorio(primero) + "}");
			pw.println(escritorioPasajero(primero));
			pw.println("}");
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException ex) {
				
			}
		}
	}
	
	public String reemplazar(int posMemoria) {
		String cadena = String.valueOf(posMemoria);
		return cadena.replace("-", "_");
	}
	
	public String generarDotListaAvion(Nodo primero) {
		String cadena = "";
		if(primero ==null) {
			return cadena;
		}
		Avion a = (Avion)primero.getObjeto();		
		cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\"Avion: "+a.getNumero()+"&#92;nTamanio: "+a.getTipo() + "&#92;nPasajeros: " + a.getPasajeros() + "&#92;nDesabordaje: " + a.getTurnosDesabordaje() + "&#92;nMantenimiento: " + a.getTurnosMantenimiento() + "\"];\n";
		if(primero.getSiguiente()!=null) {
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(primero.getSiguiente().hashCode()) + ";\n";
			cadena += "nodo" + reemplazar(primero.getSiguiente().hashCode())+ "->" + "nodo" + reemplazar(primero.getSiguiente().getAnterior().hashCode()) + ";\n";
			cadena += generarDotListaAvion(primero.getSiguiente());	
		}		
				
		return cadena;
	}

	public String generarDotDesabordaje(Nodo primero) {
		String cadena ="";
		if(primero==null) {
			return cadena;
		}
		Pasajero p = (Pasajero)primero.getObjeto();
		cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\" Pasajero: "+ p.getNumero()+" &#92;nMaletas: "+p.getMaletas() + " &#92;nDocumentos: " + p.getDocumentos() + " &#92;nTurnos: " + p.getTurnosRegistro() + "\"];\n";
		if(primero.getSiguiente()!=null) {
			cadena += "nodo" + reemplazar(primero.hashCode()) + "->" + "nodo"+reemplazar(primero.getSiguiente().hashCode()) + ";\n";
			cadena+= generarDotDesabordaje(primero.getSiguiente());
		}
		return cadena;
	}
	
	public String generarColaPasajero(Nodo cola) {
		String cadena = "";
		if(cola==null) {
			return cadena;
		}
		Pasajero p = (Pasajero)cola.getObjeto();
		if(p!=null) {
		cadena+= "nodo" + reemplazar(cola.hashCode()) + "[label=\" Pasajero: "+ p.getNumero() + " &#92;nTurnos: " + p.getTurnosRegistro() + "\"];\n";
		if(cola.getSiguiente()!=null) {
			cadena+="nodo" + reemplazar(cola.hashCode()) + "->" + "nodo"+reemplazar(cola.getSiguiente().hashCode()) + ";\n";
			cadena+=generarColaPasajero(cola.getSiguiente());
		}}
		return cadena;
	}
	
	public String generarDotColaAvion(Nodo primero) {
		String cadena = "";
		if(primero ==null) {
			return cadena;
		}
		Avion a = (Avion)primero.getObjeto();		
		cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\"Avion: "+a.getNumero()+"&#92;nTamanio: "+a.getTipo() + "&#92;nPasajeros: " + a.getPasajeros() + "&#92;nDesabordaje: " + a.getTurnosDesabordaje() + "&#92;nMantenimiento: " + a.getTurnosMantenimiento() + "\"];\n";
		if(primero.getSiguiente()!=null) {
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(primero.getSiguiente().hashCode()) + ";\n";			
			cadena += generarDotColaAvion(primero.getSiguiente());	
		}						
		return cadena;
	}
	
	public String generarDotEscritorio(Nodo primero) {
		String cadena = "";
		Escritorio e = (Escritorio)primero.getObjeto();
		if(e.getPasajero()==null) {
			cadena += "nodo"+reemplazar(primero.hashCode()) + "[label=\"Escritorio: " + e.getNombre() + "&#92;nEstado: " + e.getDisponible() + "&#92;nTotal Doc: " + sumaDocumentos(e) + "\"];\n" ;
		}
		else {
			cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\"Escritorio: " + e.getNombre() + "&#92;nEstado: " + e.getDisponible() + "&#92;nCliente: " + e.getPasajero().getNumero() + "&#92;nDocumentos: " + e.getPasajero().getDocumentos() + "&#92;nTurnos: " + e.getPasajero().getTurnosRegistro() + "&#92;nTotal Doc: " + sumaDocumentos(e) + "\"];\n";  
		}
		if(primero.getSiguiente()!=null) {
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(primero.getSiguiente().hashCode()) + ";\n";
			cadena += "nodo" + reemplazar(primero.getSiguiente().hashCode())+ "->" + "nodo" + reemplazar(primero.getSiguiente().getAnterior().hashCode()) + ";\n";
			cadena += generarDotEscritorio(primero.getSiguiente());
		}		
		return cadena;
	}
	
	public String escritorioPasajero(Nodo primero) {
		String cadena ="";
		Escritorio e = (Escritorio)primero.getObjeto();
		if(e.getColaPasajero().inicio!=null) {
			cadena += "nodo" + reemplazar(primero.hashCode())+"->" + "nodo"+reemplazar(e.getColaPasajero().getInicioNodo().hashCode()) + ";\n";
			cadena += generarColaPasajero(e.getColaPasajero().getInicioNodo());
		}
		if(primero.getSiguiente()!=null) {
			cadena += escritorioPasajero(primero.getSiguiente());
		}
		
		return cadena;
	}
	
	public int sumaDocumentos(Escritorio e) {
		int documentos = 0; 
		if(e.getPila().getInicioNodo()!=null) {
			Nodo aux = e.getPila().getInicioNodo();
			while(aux!=null) {
				documentos += (int)aux.getObjeto();
				aux = aux.getSiguiente();
			}
		}
		return documentos;
	}
	
	public String generarDotEstacion(Nodo primero) {
		String cadena = "";
		Mantenimiento m = (Mantenimiento)primero.getObjeto();
		if(m.getAvion()==null) {
			cadena+= "nodo" + reemplazar(primero.hashCode()) + "[label=\"Estacion: "+m.getNumero()+"&#92;nEstado: " + m.getDisponible() + "\"];\n";			
		}
		else {
			Avion a = m.getAvion();
			cadena+="nodo" + reemplazar(primero.hashCode()) + "[label=\"Estacion: "+m.getNumero()+"&#92;nEstado: " + m.getDisponible() + "&#92;nAvion: "+a.getNumero()+"&#92;nTamanio: "+a.getTipo() + "&#92;nPasajeros: " + a.getPasajeros() + "&#92;nDesabordaje: " + a.getTurnosDesabordaje() + "&#92;nMantenimiento: " + a.getTurnosMantenimiento() + "\"];\n";
		}
		if(primero.getSiguiente()!=null) {
			cadena+="nodo" + reemplazar(primero.hashCode()) + "->" + "nodo" + reemplazar(primero.getSiguiente().hashCode()) + ";\n";
			cadena += generarDotEstacion(primero.getSiguiente());
		}
		
		return cadena;
	}
	
	public String rankEstacion(Nodo primero) {
		String cadena ="";
		if(primero.getSiguiente()!=null) {
			cadena += " nodo" + reemplazar(primero.hashCode()); 
			cadena+= rankEstacion(primero.getSiguiente());
		}
		return cadena;
	}
	
	public String rankEscritorio(Nodo primero) {
		String cadena = "";
		if(primero.getSiguiente()!=null) {
			cadena += " nodo"+reemplazar(primero.hashCode());
			cadena += rankEscritorio(primero.getSiguiente());
		}
		return cadena;
	}
	
	public String mantEst(Nodo mantenimiento, Nodo cola) {
		String cadena = "";
		if(mantenimiento!=null) {
			if(cola!=null) {
				cadena+="nodo"+reemplazar(mantenimiento.hashCode()) + "->" + "nodo" + reemplazar(cola.hashCode()) +"\n" ;
				cadena+=mantEst(mantenimiento.getSiguiente(),cola);
			}
		}
		return cadena;
	}
	
	public String generarDotListaMaleta(Nodo primero, Nodo ultimo) {
		String cadena = "";		
		if(primero==null) {
			return cadena;
		}
		cadena += "nodo" + reemplazar(primero.hashCode()) + "[label=\""+primero.getObjeto()+ "\"];\n";
		if(primero.getSiguiente()!=ultimo) {		
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(primero.getSiguiente().hashCode()) + ";\n";	
			cadena += "nodo" + reemplazar(primero.getSiguiente().hashCode())+ "->" + "nodo" + reemplazar(primero.getSiguiente().getAnterior().hashCode()) + ";\n";
			cadena += generarDotListaMaleta(primero.getSiguiente(),ultimo);
		}
		if(primero.getSiguiente()==ultimo) {
			cadena += "nodo"+ reemplazar(primero.hashCode())+"->" +"nodo"+reemplazar(ultimo.hashCode()) + ";\n";	
			cadena += "nodo" + reemplazar(ultimo.hashCode())+ "->" + "nodo" + reemplazar(primero.hashCode()) + ";\n";
		}
		return cadena;
	}	
	
	public void generarImagen(String direccionDot, String direccionImagen) {
		String doPath ="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";		
		String [] cmd = new String[5];
		cmd[0] = doPath;
		cmd[1] = "-Tjpg";
		cmd[2] = direccionDot;
		cmd[3] = "-o";
		cmd[4] = direccionImagen;					
		
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}	
}
