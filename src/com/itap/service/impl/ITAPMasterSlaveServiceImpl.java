package com.itap.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itap.exception.ServiceException;
import com.itap.model.DO.MasterSlaveDetailsDO;
import com.itap.service.ITAPJenkinsConfigService;
import com.itap.service.ITAPMasterSlaveService;
import com.itap.util.CreateJenkinsJob;

@Component("masterSlaveService")
public class ITAPMasterSlaveServiceImpl extends ITAPBaseServiceImpl implements
		ITAPMasterSlaveService {

	private long serverId = 1l;
	@Autowired
	ITAPJenkinsConfigService itapJenkinsConfigService;

	@Override
	public List<MasterSlaveDetailsDO> getAllMasterSlaveNodes() {

		List<MasterSlaveDetailsDO> list = new ArrayList<MasterSlaveDetailsDO>();
		String jsonObject = "";
		try {
			jsonObject = CreateJenkinsJob.getMasterSlavesNodes(itapJenkinsConfigService
					.getJenkinsUrl(serverId));
			MasterSlaveDetailsDO do1 = new MasterSlaveDetailsDO();
			MasterSlaveDetailsDO do2 = new MasterSlaveDetailsDO();

			do1.setName("Master");
			do2.setName("sub Nodes");
			list.add(do1);
			list.add(do2);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		return list;
	}
}
