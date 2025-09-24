-- Ofertas de ejemplo
INSERT INTO ofertas (solicitud_id, titulo, estado, descripcion, requisitos_minimos, anonima, area, idioma, pais, localizacion, salario_modalidad, salario_moneda, salario_desde, salario_hasta, salario_mostrar)
VALUES
 (1001, 'Desarrollador Java Senior', 'Abierta', 'Rol para proyecto fintech', '5+ años Java, Spring Boot', 0, 'Tecnología', 'Español', 'Chile', 'Santiago', 'Bruto', 'CLP', 2500000, 3500000, 1),
 (1002, 'Analista QA', 'Abierta', 'Aseguramiento de calidad', '2+ años QA, automatización', 0, 'Calidad', 'Español', 'Chile', 'Remoto', 'Bruto', 'CLP', 1200000, 1800000, 1);

-- Especificaciones asociadas por oferta_id
INSERT INTO especificaciones (oferta_id, numero_vacantes, personal_a_cargo, modalidad_trabajo, categoria, sector, nivel_profesional, departamento, experiencia_minima, jornada_laboral, formacion_minima)
VALUES
 (1, 2, 0, 'Híbrido', 'Desarrollo', 'Fintech', 'Senior', 'TI', '5 años', 'Completa', 'Ingeniería en Informática'),
 (2, 1, 0, 'Remoto', 'QA', 'Tecnología', 'Semi-Senior', 'Calidad', '2 años', 'Completa', 'Técnico/Universitario');
