package service;

public enum TipoCargo {
	COORDENADOR {
		@Override
		public CalculaSalario getCargo() {
			// TODO Auto-generated method stub
			return new ImpressaoHolerite(new Coordenador());
		}
	},
	DIRETOR {
		@Override
		public CalculaSalario getCargo() {
			// TODO Auto-generated method stub
			return new ImpressaoHolerite(new Diretor());
		}
	},
	PROFESSOR {
		@Override
		public CalculaSalario getCargo() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	public abstract CalculaSalario getCargo();
}
