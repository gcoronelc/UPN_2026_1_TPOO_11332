using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana0302
{
    public class ListaDoble
    {
        private Nodo cabeza;
        private Nodo cola;

        public ListaDoble()
        {
            cabeza = null;
            cola = null;
        }
        public void Insertar(string nombre)
        {
            Nodo nuevo = new Nodo(nombre);
            if (cabeza == null)
            {
                cabeza = nuevo;
                cola = nuevo;
            }
            else
            {
                cola.Siguiente = nuevo;
                nuevo.Anterior = cola;
                cola = nuevo;
            }
        }
        public List<String> ObtenerNombres()
        {
            List<string> nombres = new List<string>();
            Nodo actual = cabeza;
            while (actual != null)
            {
                nombres.Add(actual.Nombre);
                actual = actual.Siguiente;
            }
            return nombres;
        }
    }
}
