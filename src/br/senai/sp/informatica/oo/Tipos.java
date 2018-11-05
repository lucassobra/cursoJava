package br.senai.sp.informatica.oo;

public enum Tipos {
	DE_CONSTRUCAO{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "De construção";
		}
		
	},
	
	FACA_VOCE_MESMO{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Faça você mesmo";
		}
		
	},
	DE_PINTURA{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "De pintura";
		}
		
	},
	PARA_CARROS{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Para carros";
		}
		
	};
} 
