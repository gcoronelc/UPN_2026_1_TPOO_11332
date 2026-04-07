using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana0302
{
    public class Nodo
    {
        public string Nombre { get; set; }
        public Nodo Anterior { get; set; }
        public Nodo Siguiente { get; set; }

        public Nodo(string nombre)
        {
            Nombre = nombre;
            Anterior = null;
            Siguiente = null;
        }
    }
}
