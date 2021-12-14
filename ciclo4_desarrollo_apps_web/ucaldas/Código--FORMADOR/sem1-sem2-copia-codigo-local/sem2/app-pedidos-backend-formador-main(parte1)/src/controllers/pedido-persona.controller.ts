import {
  repository,
} from '@loopback/repository';
import {
  param,
  get,
  getModelSchemaRef,
} from '@loopback/rest';
import {
  Pedido,
  Persona,
} from '../models';
import {PedidoRepository} from '../repositories';

export class PedidoPersonaController {
  constructor(
    @repository(PedidoRepository)
    public pedidoRepository: PedidoRepository,
  ) { }

  @get('/pedidos/{id}/persona', {
    responses: {
      '200': {
        description: 'Persona belonging to Pedido',
        content: {
          'application/json': {
            schema: {type: 'array', items: getModelSchemaRef(Persona)},
          },
        },
      },
    },
  })
  async getPersona(
    @param.path.string('id') id: typeof Pedido.prototype.id,
  ): Promise<Persona> {
    return this.pedidoRepository.persona(id);
  }
}
