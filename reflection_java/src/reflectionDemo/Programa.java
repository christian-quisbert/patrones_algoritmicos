package reflectionDemo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import reflectionDemo.MiClase;

public class Programa {
	public static void main(String[] args){
		MiClase objetoDeMiClase = new MiClase();
		Class<?extends MiClase> objetoDeClassConInfoDeMiClase = objetoDeMiClase.getClass();
		
		//Obtener el Class directamente de un objeto (Recordatorio: un objeto de tipo String válido es un texto entre comillas)
		Class classDelTexto = "un texto".getClass();
		System.out.println(classDelTexto);		
		Integer numero = 5;
		Class classDelNumero = numero.getClass();
		System.out.println(classDelNumero);
		
		//Para tipos primitivos tenemos que usar “.class” o con “.TYPE”
		Class classDeBooleanA = boolean.class;
		//Class classDeBooleanB = boolean.TYPE;
		
		//Obtener el nombre de la clase
		String 	nombreDeLaClase = objetoDeClassConInfoDeMiClase.getSimpleName();
		System.out.println(nombreDeLaClase);
		
		//*** Obtener Variables ***//
		
		//Si queremos obtener una variable pública
		Field variableString = null;
		try {
			variableString = objetoDeClassConInfoDeMiClase.getField("unaVariableString");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(variableString);
		System.out.println("-----");
		
		//*** Obtener FUNCIONES ***//
		
		//Si queremos obtener un método público. Si tiene parámetros podremos pasar cada uno de sus tipos.class  en orden después del nombre
		try {
			Method metodoGetString = objetoDeClassConInfoDeMiClase.getMethod("getUnaVariableString", String.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Si queremos obtener un método, sea privado o no. Si tiene parámetros podremos pasar cada uno de sus tipos.class en orden después del nombre
		try {
			Method metodoGetInt = objetoDeClassConInfoDeMiClase.getDeclaredMethod("getUnaVariableInt", int.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Si queremos obtener un array con todas las variables públicas de nuestra clase
		Method[] todosLosMetodos = objetoDeClassConInfoDeMiClase.getMethods();
		for (Method variable : todosLosMetodos) {
			System.out.println(variable);
		}
		
		System.out.println("-----");
		
		//Si queremos obtener todos los métodos, independientemente de si son privados o no
		Method[] todosLosMetodosDeclarados = objetoDeClassConInfoDeMiClase.getDeclaredMethods();
		for (Method variable : todosLosMetodosDeclarados) {
			System.out.println(variable);
		}
	}

}
