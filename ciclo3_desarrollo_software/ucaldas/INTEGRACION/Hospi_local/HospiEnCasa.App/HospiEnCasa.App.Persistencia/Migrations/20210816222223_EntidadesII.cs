using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace HospiEnCasa.App.Persistencia.Migrations
{
    public partial class EntidadesII : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "Ciudad",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Codigo",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Correo",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Direccion",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Discriminator",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");

            migrationBuilder.AddColumn<int>(
                name: "EnfermeraId",
                table: "Personas",
                type: "int",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Especialidad",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<int>(
                name: "FamiliarId",
                table: "Personas",
                type: "int",
                nullable: true);

            migrationBuilder.AddColumn<DateTime>(
                name: "FechaNacimiento",
                table: "Personas",
                type: "datetime2",
                nullable: true);

            migrationBuilder.AddColumn<int>(
                name: "HistoriaId",
                table: "Personas",
                type: "int",
                nullable: true);

            migrationBuilder.AddColumn<int>(
                name: "HorasLaborales",
                table: "Personas",
                type: "int",
                nullable: true);

            migrationBuilder.AddColumn<float>(
                name: "Latitud",
                table: "Personas",
                type: "real",
                nullable: true);

            migrationBuilder.AddColumn<float>(
                name: "Longitud",
                table: "Personas",
                type: "real",
                nullable: true);

            migrationBuilder.AddColumn<int>(
                name: "MedicoId",
                table: "Personas",
                type: "int",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Parentesco",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "RegistroRethus",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "TarjetaProfesional",
                table: "Personas",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.CreateTable(
                name: "Historias",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Diagnostico = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Entorno = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Historias", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "SignosVitales",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    FechaHora = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Valor = table.Column<float>(type: "real", nullable: false),
                    Signo = table.Column<int>(type: "int", nullable: false),
                    PacienteId = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_SignosVitales", x => x.Id);
                    table.ForeignKey(
                        name: "FK_SignosVitales_Personas_PacienteId",
                        column: x => x.PacienteId,
                        principalTable: "Personas",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "SugerenciasCuidado",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    FechaHora = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Descripcion = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    HistoriaId = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_SugerenciasCuidado", x => x.Id);
                    table.ForeignKey(
                        name: "FK_SugerenciasCuidado_Historias_HistoriaId",
                        column: x => x.HistoriaId,
                        principalTable: "Historias",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Personas_EnfermeraId",
                table: "Personas",
                column: "EnfermeraId");

            migrationBuilder.CreateIndex(
                name: "IX_Personas_FamiliarId",
                table: "Personas",
                column: "FamiliarId");

            migrationBuilder.CreateIndex(
                name: "IX_Personas_HistoriaId",
                table: "Personas",
                column: "HistoriaId");

            migrationBuilder.CreateIndex(
                name: "IX_Personas_MedicoId",
                table: "Personas",
                column: "MedicoId");

            migrationBuilder.CreateIndex(
                name: "IX_SignosVitales_PacienteId",
                table: "SignosVitales",
                column: "PacienteId");

            migrationBuilder.CreateIndex(
                name: "IX_SugerenciasCuidado_HistoriaId",
                table: "SugerenciasCuidado",
                column: "HistoriaId");

            migrationBuilder.AddForeignKey(
                name: "FK_Personas_Historias_HistoriaId",
                table: "Personas",
                column: "HistoriaId",
                principalTable: "Historias",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Personas_Personas_EnfermeraId",
                table: "Personas",
                column: "EnfermeraId",
                principalTable: "Personas",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Personas_Personas_FamiliarId",
                table: "Personas",
                column: "FamiliarId",
                principalTable: "Personas",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Personas_Personas_MedicoId",
                table: "Personas",
                column: "MedicoId",
                principalTable: "Personas",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Personas_Historias_HistoriaId",
                table: "Personas");

            migrationBuilder.DropForeignKey(
                name: "FK_Personas_Personas_EnfermeraId",
                table: "Personas");

            migrationBuilder.DropForeignKey(
                name: "FK_Personas_Personas_FamiliarId",
                table: "Personas");

            migrationBuilder.DropForeignKey(
                name: "FK_Personas_Personas_MedicoId",
                table: "Personas");

            migrationBuilder.DropTable(
                name: "SignosVitales");

            migrationBuilder.DropTable(
                name: "SugerenciasCuidado");

            migrationBuilder.DropTable(
                name: "Historias");

            migrationBuilder.DropIndex(
                name: "IX_Personas_EnfermeraId",
                table: "Personas");

            migrationBuilder.DropIndex(
                name: "IX_Personas_FamiliarId",
                table: "Personas");

            migrationBuilder.DropIndex(
                name: "IX_Personas_HistoriaId",
                table: "Personas");

            migrationBuilder.DropIndex(
                name: "IX_Personas_MedicoId",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Ciudad",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Codigo",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Correo",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Direccion",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Discriminator",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "EnfermeraId",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Especialidad",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "FamiliarId",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "FechaNacimiento",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "HistoriaId",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "HorasLaborales",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Latitud",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Longitud",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "MedicoId",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "Parentesco",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "RegistroRethus",
                table: "Personas");

            migrationBuilder.DropColumn(
                name: "TarjetaProfesional",
                table: "Personas");
        }
    }
}
