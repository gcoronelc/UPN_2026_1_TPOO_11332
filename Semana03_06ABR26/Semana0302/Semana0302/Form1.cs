namespace Semana0302
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        ListaDoble lista = new ListaDoble();

        private void btnCrear_Click(object sender, EventArgs e)
        {
            string nombre = txtNombre.Text.Trim();
            if (!string.IsNullOrEmpty(nombre))
            {
                lista.Insertar(nombre);
                MessageBox.Show("Nombre agregado a la lista", "Exito");
                txtNombre.Clear();
            }
            else
            {
                MessageBox.Show("Ingrese un nombre", "Advertencia");
            }
        }

        private void btnMostrar_Click(object sender, EventArgs e)
        {
            dgvNombres.Rows.Clear();
            List<string> nombres = lista.ObtenerNombres();
            foreach(string nombre in nombres)
            {
                dgvNombres.Rows.Add(nombre);
            }
        }
    }
}
