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
  Pedido,
  Producto,
} from '../models';
import {PedidoRepository} from '../repositories';

export class PedidoProductoController {
  constructor(
    @repository(PedidoRepository) protected pedidoRepository: PedidoRepository,
  ) { }

  @get('/pedidos/{id}/producto', {
    responses: {
      '200': {
        description: 'Pedido has one Producto',
        content: {
          'application/json': {
            schema: getModelSchemaRef(Producto),
          },
        },
      },
    },
  })
  async get(
    @param.path.string('id') id: string,
    @param.query.object('filter') filter?: Filter<Producto>,
  ): Promise<Producto> {
    return this.pedidoRepository.producto(id).get(filter);
  }

  @post('/pedidos/{id}/producto', {
    responses: {
      '200': {
        description: 'Pedido model instance',
        content: {'application/json': {schema: getModelSchemaRef(Producto)}},
      },
    },
  })
  async create(
    @param.path.string('id') id: typeof Pedido.prototype.id,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Producto, {
            title: 'NewProductoInPedido',
            exclude: ['id'],
            optional: ['pedidoId']
          }),
        },
      },
    }) producto: Omit<Producto, 'id'>,
  ): Promise<Producto> {
    return this.pedidoRepository.producto(id).create(producto);
  }

  @patch('/pedidos/{id}/producto', {
    responses: {
      '200': {
        description: 'Pedido.Producto PATCH success count',
        content: {'application/json': {schema: CountSchema}},
      },
    },
  })
  async patch(
    @param.path.string('id') id: string,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Producto, {partial: true}),
        },
      },
    })
    producto: Partial<Producto>,
    @param.query.object('where', getWhereSchemaFor(Producto)) where?: Where<Producto>,
  ): Promise<Count> {
    return this.pedidoRepository.producto(id).patch(producto, where);
  }

  @del('/pedidos/{id}/producto', {
    responses: {
      '200': {
        description: 'Pedido.Producto DELETE success count',
        content: {'application/json': {schema: CountSchema}},
      },
    },
  })
  async delete(
    @param.path.string('id') id: string,
    @param.query.object('where', getWhereSchemaFor(Producto)) where?: Where<Producto>,
  ): Promise<Count> {
    return this.pedidoRepository.producto(id).delete(where);
  }
}
