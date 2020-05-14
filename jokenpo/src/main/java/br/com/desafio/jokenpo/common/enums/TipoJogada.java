package br.com.desafio.jokenpo.common.enums;

public enum TipoJogada {

	PEDRA {
		@Override
		public boolean ganha(TipoJogada tipo) {
			return tipo.equals(TipoJogada.LAGARTO) || tipo.equals(TipoJogada.TESOURA);
		}

		@Override
		public boolean perde(TipoJogada tipo) {
			return tipo.equals(TipoJogada.SPOCK) || tipo.equals(TipoJogada.PAPEL);
		}
	},
	PAPEL {
		@Override
		public boolean ganha(TipoJogada tipo) {
			return tipo.equals(TipoJogada.PEDRA) || tipo.equals(TipoJogada.SPOCK);
		}

		@Override
		public boolean perde(TipoJogada tipo) {
			return tipo.equals(TipoJogada.TESOURA) || tipo.equals(TipoJogada.LAGARTO);
		}
	},
	TESOURA {
		@Override
		public boolean ganha(TipoJogada tipo) {
			return tipo.equals(TipoJogada.LAGARTO) || tipo.equals(TipoJogada.PAPEL);
		}

		@Override
		public boolean perde(TipoJogada tipo) {
			return tipo.equals(TipoJogada.SPOCK) || tipo.equals(TipoJogada.PEDRA);

		}
	},
	LAGARTO {
		@Override
		public boolean ganha(TipoJogada tipo) {
			return tipo.equals(TipoJogada.SPOCK) || tipo.equals(TipoJogada.PAPEL);
		}

		@Override
		public boolean perde(TipoJogada tipo) {
			return tipo.equals(TipoJogada.TESOURA) || tipo.equals(TipoJogada.PEDRA);

		}
	},
	SPOCK {
		@Override
		public boolean ganha(TipoJogada tipo) {
			return tipo.equals(TipoJogada.TESOURA) || tipo.equals(TipoJogada.PEDRA);
		}

		@Override
		public boolean perde(TipoJogada tipo) {
			return tipo.equals(TipoJogada.LAGARTO) || tipo.equals(TipoJogada.PAPEL);

		}
	};

	public abstract boolean ganha(TipoJogada tipo);

	public abstract boolean perde(TipoJogada tipo);

}