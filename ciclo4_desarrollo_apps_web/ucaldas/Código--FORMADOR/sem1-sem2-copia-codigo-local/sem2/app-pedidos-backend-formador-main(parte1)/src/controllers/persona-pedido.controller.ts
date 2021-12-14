import {
  Count,
  CountSchema,
  Filter,
  repository,
  Where,
} from '@loopback/repository';
import {
  del,
  get,
  getModelSchemaRef,
  getWhereSchemaFor,
  param,
  patch,
  post,
  requestBody,
} from '@loopback/rest';
import {
  Persona,
  Pedido,
} from '../models';
import {PersonaRepository} from '../repositories';

export class PersonaPedidoController {
  constructor(
    @repository(PersonaRepository) protected personaRepository: PersonaRepository,
  ) { }

  @get('/personas/{id}/pedidos', {
    responses: {
      '200': {
        description: 'Array of Persona has many Pedido',
        content: {
          'application/json': {
            schema: {type: 'array', items: getModelSchemaRef(Pedido)},
          },
        },
      },
    },
  })
  async find(
    @param.path.string('id') id: string,
    @param.query.object('filter') filter?: Filter<Pedido>,
  ): Promise<Pedido[]> {
    return this.personaRepository.pedidos(id).find(filter);
  }

  @post('/personas/{id}/pedidos', {
    responses: {
      '200': {
        description: 'Persona model instance',
        content: {'application/json': {schema: getModelSchemaRef(Pedido)}},
      },
    },
  })
  async create(
    @param.path.string('id') id: typeof Persona.prototype.id,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Pedido, {
            title: 'NewPedidoInPersona',
            exclude: ['id'],
            optional: ['personaId']
          }),
        },
      },
    }) pedido: Omit<Pedido, 'id'>,
  ): Promise<Pedido> {
    return this.personaRepository.pedidos(id).create(pedido);
  }

  @patch('/personas/{id}/pedidos', {
    responses: {
      '200': {
        description: 'Persona.Pedido PATCH success count',
        content: {'application/json': {schema: CountSchema}},
      },
    },
  })
  async patch(
    @param.path.string('id') id: string,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Pedido, {partial: true}),
        },
      },
    })
    pedido: Partial<Pedido>,
    @param.query.object('where', getWhereSchemaFor(Pedido)) where?: Where<Pedido>,
  ): Promise<Count> {
    return this.personaRepository.pedidos(id).patch(pedido, where);
  }

  @del('/personas/{id}/pedidos', {
    responses: {
      '200': {
        description: 'Persona.Pedido DELETE success count',
        content: {'application/json': {schema: CountSchema}},
      },
    },
  })
  async delete(
    @param.path.string('id') id: string,
    @param.query.object('where', getWhereSchemaFor(Pedido)) where?: Where<Pedido>,
  ): Promise<Count> {
    return this.personaRepository.pedidos(id).delete(where);
  }
}
