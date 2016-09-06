/*
 * Copyright (c) 2016 Zhan Yi
 * All Rights Reserved
 * Licensed Materials - Property of Zhan Yi.
 *
 */

package org.z.cdbc.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.texen.util.FileUtil;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{

	public static void main( String[] args ) throws IOException, ClassNotFoundException {
		final String [] vm_resources = {
				"daos.h.vm",
				"daos.cc.vm",
				"entities.h.vm",
				"messages.proto.vm",
				"pb_msg_conv.cc.vm",
				"pb_msg_conv.h.vm",
				"soci_entity_conv.h.vm",
		};

	   CommandOptions options = new CommandOptions();
		JCommander cmd = new JCommander(options);
		try {
			cmd.parse(args);
		} catch (ParameterException e) {
			System.out.println(e.getMessage());
			cmd.usage();
			return;
		}

		FileUtil.mkdir(options.getOutDir());

		VelocityEngine engine = new VelocityEngine();
		engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		engine.init();

		VelocityContext ctx = new VelocityContext();

		List<Table> tables = new ArrayList<Table>();
		Class.forName(options.getJdbcDriver());
		MetaDataParser parser = new MetaDataParser(options.getUrl(),
				options.getUser(), options.getPassword());
		parser.setDriverClassName(options.getJdbcDriver());

		String [] tablist = options.getTablelist().split(",");
		for (int i = 0; i < tablist.length; i++) {
			try {
				tables.add(parser.parse(tablist[i].trim()));
			} catch (SQLException e) {
				e.printStackTrace();
				return;
			}
		}


		ctx.put("filename", options.getPackageName());
		ctx.put("tables", tables);
		ctx.put("package", options.getPackageName());


		for (int i = 0; i < vm_resources.length; i++) {
			Template template = engine.getTemplate(vm_resources[i]);

			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream(FileUtil.file(
							options.getOutDir(),
							options.getPackageName() + "_" + vm_resources[i].replace(".vm", ""))
					),
					"UTF-8"
			);

			template.merge(ctx, writer);
			writer.close();
		}

	}
}
