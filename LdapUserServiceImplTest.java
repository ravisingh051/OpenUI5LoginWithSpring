package com.alight.idis.web.metainfo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.alight.idis.web.dto.LdapUserDTO;
import com.alight.idis.web.metainfo.security.WebSecurityConfig;
import com.alight.idis.web.util.LDAPAttributeMapper;
import java.util.List;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {WebSecurityConfig.class, LdapUserServiceImpl.class})
@TestPropertySource(properties = {"ldap.protocol=ldaps","ldap.host=l4dwepdc7724.d2.hewitt.com","ldap.port=636","ldap.user.search.base=ou=Users,ou=UAG",
		"ldap.basedn=dc=d2,dc=hewitt,dc=com","ldap.userdn=idisServiceUser","ldap.password=XC.hj!%3456#123&824","ldap.group.search.base=ou=Groups,ou=UAG"})
//@TestPropertySource(properties = {"ldap.protocol=ldap","ldap.host=nalinadcpvip.alight.com","ldap.port=389","ldap.user.search.base=ou=Users and Groups",
//		"ldap.basedn=dc=hewitt,dc=com","ldap.userdn=idisServiceUser","ldap.group.search.base=ou=Application Groups,ou=Users and Groups",
//		"ldap.password=CV.!987%gh$kl7891234"})
public class LdapUserServiceImplTest {

 // @InjectMocks
	@Autowired
  private LdapUserServiceImpl target;

  //@Mock
  

 

  @Test
  public void testGetLDAPUserByFilter() throws NamingException {
    

    Filter filter = new EqualsFilter("cn", "d0154467");

    List<LdapUserDTO> result = target.getLDAPUserByFilter(filter);
    System.out.println(result);

  }

}
