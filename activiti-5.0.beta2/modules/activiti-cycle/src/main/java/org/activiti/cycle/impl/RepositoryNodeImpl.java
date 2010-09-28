/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.cycle.impl;

import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;

import org.activiti.cycle.RepositoryNode;
import org.activiti.cycle.RepositoryNodeMetadata;

/**
 * Superclass for the composite of folders and files. Holds a reference to the
 * API used to query sub folders and files in order to enable lazy loading of
 * them.
 * 
 * @author bernd.ruecker@camunda.com
 */
public class RepositoryNodeImpl implements RepositoryNode, Serializable {

  private static final long serialVersionUID = 1L;

  protected Logger log = Logger.getLogger(this.getClass().getName());

  /**
   * local part of the URL for node. This is the one and only used unique
   * identifier for the node used by the client and the repository API. All
   * details can be queried by this URL later on, by adding the repo base URL to
   * the beginning.
   * 
   * For Signavio the ID is simply an UUID generated by Signavio. For FileSystem
   * this is the "local" part of the absolute path of the file WITHOUT the
   * configured root folder of the FileSystem connector. For other repos this
   * may be whatever it needs to be, the client shouldn't really care.
   */
  private String id;
  
  private final RepositoryNodeMetadata metadata = new RepositoryNodeMetadataImpl();

  public RepositoryNodeImpl(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " [id=" + id + ";metadata=" + metadata + "]";
  }

  public RepositoryNodeMetadata getMetadata() {
    return metadata;
  }

  public Map<String, String> getMetadataAsMap() {
    return metadata.getAsStringMap();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
