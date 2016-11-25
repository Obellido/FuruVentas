using DesktopApp.ClienteServices;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DesktopApp.Mantenimientos.Clientes
{
    public partial class ListaClientes : Form
    {
        private static ListaClientes instance;

        private ListaClientes() {
            InitializeComponent();
            this.recordsBindingSource.DataSource = new ClienteWSClient().ListaCliente().Records;
        }

        public static ListaClientes Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new ListaClientes();
                    instance.FormClosing += Instance_FormClosing;
                }
                return instance;
            }
        }

        private static void Instance_FormClosing(object sender, FormClosingEventArgs e)
        {
            instance = null;
        }
    }
}
