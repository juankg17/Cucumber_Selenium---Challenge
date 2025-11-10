Feature: Gestion formulario Usuario
  Como usuario quiero gestionar formulario para alta de usuarios

  Scenario: Agregar exitosamente registro de usuario
    Given El usuario se encuentra en la página de registro de usuarios
    When El usuario completa datos del formulario
    And Presiona botón Enviar
    Then Se muestra mensaje de Registro Exitoso

  @Ignore
  Scenario: Agregar usuario con email invalido
    Given El usuario se encuentra en la página de registro de usuarios
    When El usuario completa formulario con email invalido del formulario
    And Presiona botón Enviar
    Then Se muestra mensaje Por favor, introduce un email válido.

  @Ignore
  Scenario: Agregar usuario con contraseñas no coincidentes
    Given El usuario se encuentra en la página de registro de usuarios
    When El usuario completa formulario con contraseñas no coincidentes
    And Presiona botón Enviar
    Then Se muestra mensaje Las contraseñas no coinciden.

  @Ignore
  Scenario: Agregar usuario con edad menor a 1
    Given El usuario se encuentra en la página de registro de usuarios
    When El usuario completa formulario con edad menor a 1
    And Presiona botón Enviar
    Then Se muestra mensaje La edad debe ser mayor a 0