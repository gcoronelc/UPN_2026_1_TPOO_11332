using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana0301
{
    public class NodoDoble
    {
        public int Dato;
        public NodoDoble Siguente;
        public NodoDoble Anterior;

        public NodoDoble(int dato)
        {
            Dato = dato;
            Siguente = null;
            Anterior = null;
        }
    }
}
