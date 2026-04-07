using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana0301
{
    public class ListaDoble
    {
        private NodoDoble cabeza;

        public void InsertarAlInicio(int valor)
        {
            NodoDoble nuevo = new NodoDoble(valor);
            if (cabeza == null)
            {
                cabeza = nuevo;
            }
            else
            {
                nuevo.Siguente = cabeza;
                cabeza.Anterior = nuevo;
                cabeza = nuevo;
            }
            Console.WriteLine("Nodo insertado al inicio");
        }

        public void InsertarAlFinal(int valor)
        {
            NodoDoble nuevo = new NodoDoble(valor);
            if (cabeza == null)
            {
                cabeza = nuevo;
                return;
            }
            else
            {
                NodoDoble actual = cabeza;
                while (actual.Siguente != null)
                {
                    actual = actual.Siguente;
                }
                actual.Siguente = nuevo;
                nuevo.Anterior = actual;
            }
            Console.WriteLine("Nodo insertado al final");
        }
        public void EliminarPorValor(int valor)
        {
            if (cabeza == null)
            {
                Console.WriteLine("Lista vacia");
                return;
            }
            NodoDoble actual = cabeza;
            while(actual!=null && actual.Dato != valor)
            {
                actual = actual.Siguente;
            }
            if (actual == null)
            {
                Console.WriteLine("Valor no encontrado");
                return;
            }

            if (actual.Anterior != null)
            {
                actual.Anterior.Siguente = actual.Siguente;
            }
            else
            {
                cabeza = actual.Siguente;
            }
            if (actual.Siguente != null)
            {
                actual.Siguente.Anterior = actual.Anterior;
            }
            Console.WriteLine($"Nodo con valor {valor} eliminado.");
        }

        public void Mostrar()
        {
            if (cabeza == null)
            {
                Console.WriteLine("Lista vacia");
                return;
            }
            NodoDoble actual = cabeza;
            Console.Write("Lista hacia adelante:");
            while (actual != null)
            {
                Console.Write($"[{actual.Dato}] <->");
                actual = actual.Siguente;
            }
            Console.WriteLine("NULL");
        }

        public void MostrarInversa()
        {
            if (cabeza == null)
            {
                Console.WriteLine("Lista vacia");
                return;
            }
            NodoDoble actual = cabeza;
            while (actual.Siguente != null)
            {
                actual = actual.Siguente;
            }
            Console.WriteLine("Lista en orden inverso:");
            while (actual != null)
            {
                Console.Write($"[{actual.Dato}]<->");
                actual = actual.Anterior;
            }
            Console.WriteLine("NULL");
        }
        public void Buscar(int valor)
        {
            NodoDoble actual = cabeza;
            while (actual!=null)
            {
                if (actual.Dato == valor)
                {
                    Console.WriteLine($"El valor{valor} SI se encuentra en la lista");
                    return;
                }
                actual = actual.Siguente;
            }
            Console.WriteLine($"El valor{valor} NO se encuentra en la lista");
        }
        public int SumaPares()
        {
            int suma = 0;
            NodoDoble actual = cabeza;
            while (actual != null)
            {
                if (actual.Dato % 2 == 0)
                {
                    suma += actual.Dato;
                }
                actual = actual.Siguente;
            }
            return suma;
        }
        public int SumaImpares()
        {
            int suma = 0;
            NodoDoble actual = cabeza;
            while (actual != null)
            {
                if (actual.Dato % 2!= 0)
                {
                    suma += actual.Dato;
                }
                actual = actual.Siguente;
            }
            return suma;
        }
    }
}
