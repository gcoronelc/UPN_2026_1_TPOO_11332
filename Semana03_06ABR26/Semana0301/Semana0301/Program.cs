using Semana0301;

class Program
{
    static void Main()
    {
        ListaDoble lista = new ListaDoble();
        int opcion=0;
        do
        {
            Console.WriteLine("\n====MENU LISTA DOBLEMENTE ENLAZADA======");
            Console.WriteLine("(1) Insertar al inicio");
            Console.WriteLine("(2) Insertar al final");
            Console.WriteLine("(3) Eliminar valor");
            Console.WriteLine("(4) Mostrar lista hacia adelante");
            Console.WriteLine("(5) Mostrar lista en orden inverso");
            Console.WriteLine("(6) Buscar un valor");
            Console.WriteLine("(7) Sumar numero pares");
            Console.WriteLine("(8) Sumar numero impares");
            Console.WriteLine("(0) Salirs");
            Console.WriteLine("Seleccione un opcion:");
            opcion = int.Parse(Console.ReadLine());
            switch (opcion)
            {
                case 1:
                    Console.WriteLine("Ingrese valor a insertar al inicio:");
                    lista.InsertarAlInicio(int.Parse(Console.ReadLine()));
                    break;
                case 2:
                    Console.WriteLine("Ingrese valor a insertar al final:");
                    lista.InsertarAlFinal(int.Parse(Console.ReadLine()));
                    break;
                case 3:
                    Console.WriteLine("Ingrese valor a eliminar:");
                    lista.EliminarPorValor(int.Parse(Console.ReadLine()));
                    break;
                case 4:
                    lista.Mostrar();
                    break;
                case 5:
                    lista.MostrarInversa();
                    break;
                case 6:
                    Console.WriteLine("Ingrese valor a buscar:");
                    lista.Buscar(int.Parse(Console.ReadLine()));
                    break;
                case 7:
                    Console.WriteLine($"Suma pares:{lista.SumaPares()}");
                    break;
                case 8:
                    Console.WriteLine($"Suma impares:{lista.SumaImpares()}");
                    break;
                case 0:
                    Console.WriteLine("Saliendo del Programa");
                    break;
                default:
                    Console.WriteLine("Opcion Invalida");
                    break;
            }
        } while (opcion != 0);
    }
   /*ListaDoble lista = new ListaDoble();
        lista.InsertarAlFinal(10);
        lista.InsertarAlFinal(20);
        lista.InsertarAlFinal(30);
        lista.Mostrar();
    Double Linkend List
     es una estructura de datos donde cada nodo contiene
     * un valor o dato
     * un puntero al nodo siguiente(next)
     * un puntero al nodo anterior(prev)
     ventajas:
     se puede recorrer en ambos sentidos
     eliminacion mas eficiente que en la lista simple

     NULL<-[A]<->[B]<->[C]->NULL
     
     */
}